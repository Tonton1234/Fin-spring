package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.ProfesseurRestResponse;
import apii.apii.apii.Services.ProfesseurServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.ProfesseurRequestDto;
import apii.apii.apii.dto.response.ProfesseurClasseModulesResponseDto;
import apii.apii.apii.dto.response.ProfesseurResponseDto;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.services.ProfesseurClasseModulesServices;
import coree.coree.coree.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class ProfesseurRestResponseImpl implements ProfesseurRestResponse {
    private final ProfesseurService professeurService;
    private final ProfesseurServiceRest professeurServiceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerProfesseurs(int page, int size, String keyword) {
        Page<Professeur> professeurs=professeurService.findProfesseurByActiveTrue (PageRequest.of(page,size));
        Page<ProfesseurResponseDto> dataDto = professeurs.map(ProfesseurResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(ProfesseurRequestDto professeurRequestDto, BindingResult bindingResult) {

        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            System.out.println("ok");
            professeurServiceRest.add(professeurRequestDto);
            response= RestResponse.response(professeurRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
