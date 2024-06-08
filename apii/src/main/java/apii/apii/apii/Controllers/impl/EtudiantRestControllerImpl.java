package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.EtudiantRestController;
import apii.apii.apii.Services.EtudiantRequestService;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.EtudiantRequestDto;
import apii.apii.apii.dto.response.EmargementResponseDto;
import apii.apii.apii.dto.response.EtudiantResponseDto;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.services.ClasseService;
import coree.coree.coree.services.CoursService;
import coree.coree.coree.services.EmmargementService;
import coree.coree.coree.services.EtudiantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class EtudiantRestControllerImpl implements EtudiantRestController {
    private final EtudiantsService etudiantsService;
    private final EtudiantRequestService etudiantRequestService;
    private final CoursService coursService;
    private final ClasseService classeService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerEtudiants(int page, int size, String keyword) {
        Page<Etudiant> etudiants=etudiantsService.findEdutiantByActiveTrue (PageRequest.of(page,size));
        Page<EtudiantResponseDto> dataDto = etudiants.map(EtudiantResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(EtudiantRequestDto etudiantRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            etudiantRequestService.add(etudiantRequestDto);
            response= RestResponse.response(etudiantRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public Page<Etudiant> convertListToPage(List<Etudiant> list, int pageNumber, int pageSize) {
        int start = pageNumber * pageSize;
        int end = Math.min((pageNumber + 1) * pageSize, list.size());

        List<Etudiant> content = list.subList(start, end);

        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), list.size());
    }


    @Override
    public ResponseEntity<Map<Object, Object>> listerEtudiantByCours(Long id, int page, int size) {
        Cours cours= coursService.getById(id);

        List<Classe> classes=cours.getClasses();
        List<Etudiant> etudiantss=new ArrayList<>();
        classes.forEach(element -> {
            element.getInscriptions().forEach(ins->{
                if (ins.getAnneeScolaire().getActive()){
                    etudiantss.add(ins.getEtudiant());
                }
            });
        });

        Page<Etudiant> et=convertListToPage(etudiantss,page,size);

        Page<EtudiantResponseDto> dataDto = et.map(EtudiantResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),
                new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerEtudiantByClasse(Long id, int page, int size) {
        Classe classe=classeService.getById(id);
        List<Etudiant> etudiantss=new ArrayList<>();

        classe.getInscriptions().forEach(ins->{
                if (ins.getAnneeScolaire().getActive()){
                    etudiantss.add(ins.getEtudiant());
                }
            });
        Page<Etudiant> et=convertListToPage(etudiantss,page,size);
        Page<EtudiantResponseDto> dataDto = et.map(EtudiantResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
  @Override
    public ResponseEntity<String> importStudents(@RequestParam("file") MultipartFile file) {
      System.out.println("ok");
        if (!file.isEmpty()) {
            etudiantRequestService.importStudentsFromExcelFile(file);
            return ResponseEntity.ok("Import successful");
        } else {
            return ResponseEntity.badRequest().body("No file selected");
        }
    }

}
