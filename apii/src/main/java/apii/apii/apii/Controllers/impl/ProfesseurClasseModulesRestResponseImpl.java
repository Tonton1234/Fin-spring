package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.ProfesseurClasseModulesRestResponse;
import apii.apii.apii.Services.ProfesseurClasseModulesServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.ModuleRequestDto;
import apii.apii.apii.dto.request.ProfesseurClasseModuleRequestDto;
import apii.apii.apii.dto.response.ClasseResponseDto;
import apii.apii.apii.dto.response.EtudiantResponseDto;
import apii.apii.apii.dto.response.ProfesseurClasseModulesResponseDto;
import apii.apii.apii.dto.response.ProfesseurResponseDto;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.ModuleRepository;
import coree.coree.coree.Data.repositories.ProfesseurClasseModulesRepository;
import coree.coree.coree.Data.repositories.ProfesseurRepository;
import coree.coree.coree.services.EtudiantsService;
import coree.coree.coree.services.ModuleService;
import coree.coree.coree.services.ProfesseurClasseModulesServices;
import coree.coree.coree.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class ProfesseurClasseModulesRestResponseImpl implements ProfesseurClasseModulesRestResponse {
    private final ProfesseurClasseModulesServices professeurClasseModulesServices;
    private final ProfesseurClasseModulesServiceRest professeurClasseModulesServiceRest;
    private final ModuleService moduleService;
    private final ProfesseurService professeurService;
    private final ModuleRepository moduleRepository;
    private final ProfesseurRepository professeurRepository;
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    @Override
    public ResponseEntity<Map<Object, Object>> listerProfesseurClasseModules(int page, int size, String keyword) {
        Page<ProfesseurClasseModules> professeurClasseModules=professeurClasseModulesServices.findProfesseurClasseModulesByActiveTrue (PageRequest.of(page,size));
        Page<ProfesseurClasseModulesResponseDto> dataDto = professeurClasseModules.map(ProfesseurClasseModulesResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerByProf(Long id, int page, int size) {
        Page<ProfesseurClasseModules> professeurClasseModules=professeurClasseModulesServices.findProfesseurClasseModulesByActiveTrue (PageRequest.of(page,size));
        Page<ProfesseurClasseModulesResponseDto> dataDto = professeurClasseModules.map(ProfesseurClasseModulesResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerByModule(Long id, int page, int size) {
        Module module=moduleRepository.findModuleById(id);

        Page<ProfesseurClasseModules> professeurClasseModules=professeurClasseModulesServiceRest.getAllByModule(module,PageRequest.of(page,size));

        List<ProfesseurClasseModules> profsClass=professeurClasseModulesRepository.findProfesseurClasseModulesByModulesAndActiveTrue(module);
        List<Professeur> professeur=new ArrayList<>();
        profsClass.forEach(element -> {
           if (!professeur.contains(element.getProfesseur())){
               professeur.add(element.getProfesseur());
           }
        });

        Page<Professeur> et=convertListToPage(professeur,page,size);
        Page<ProfesseurResponseDto> dataDto = et.map(ProfesseurResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),
                new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerByModuleAndProf(Long idProf, Long idMod, int page, int size) {
        System.out.println("ok");
        System.out.println("ok"); System.out.println("ok"); System.out.println("ok");

        Module module=moduleRepository.findModuleById(idMod);
        Professeur professeur=professeurRepository.findProfesseurById(idProf);
        List<ProfesseurClasseModules> profsClass=professeurClasseModulesRepository.findProfesseurClasseModulesByModulesAndProfesseurAndActiveTrue(module,professeur);
        List<Classe> classes=new ArrayList<>();
        profsClass.forEach(element -> {
            if (!classes.contains(element.getClasse())){
                classes.add(element.getClasse());
            }
        });

        Page<Classe> et=convertList(classes,page,size);
        System.out.println(classes);
        Page<ClasseResponseDto> dataDto = et.map(ClasseResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),
                new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(ProfesseurClasseModuleRequestDto professeurClasseModuleRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            System.out.println(professeurClasseModuleRequestDto);
            professeurClasseModulesServiceRest.add(professeurClasseModuleRequestDto);
            response= RestResponse.response(professeurClasseModuleRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public Page<Professeur> convertListToPage(List<Professeur> list, int pageNumber, int pageSize) {
        int start = pageNumber * pageSize;
        int end = Math.min((pageNumber + 1) * pageSize, list.size());

        List<Professeur> content = list.subList(start, end);

        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), list.size());
    }
    public Page<Classe> convertList(List<Classe> list, int pageNumber, int pageSize) {
        int start = pageNumber * pageSize;
        int end = Math.min((pageNumber + 1) * pageSize, list.size());

        List<Classe> content = list.subList(start, end);

        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), list.size());
    }
}
