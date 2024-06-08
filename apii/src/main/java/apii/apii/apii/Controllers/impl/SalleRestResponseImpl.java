package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.SalleRestResponse;
import apii.apii.apii.Services.SalleServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.SalleRequestDto;
import apii.apii.apii.dto.response.ProfesseurResponseDto;
import apii.apii.apii.dto.response.SalleResponseDto;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.services.ProfesseurService;
import coree.coree.coree.services.SallesService;
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
public class SalleRestResponseImpl implements SalleRestResponse {
    private final SallesService sallesService;
    private final SalleServiceRest serviceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerSalles(int page, int size, String keyword) {
        Page<SallesDeCours> sallesDeCours=sallesService.findSalleByActiveTrue (PageRequest.of(page,size));
        Page<SalleResponseDto> dataDto = sallesDeCours.map(SalleResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(SalleRequestDto salleRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            serviceRest.add(salleRequestDto);
            response= RestResponse.response(salleRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
