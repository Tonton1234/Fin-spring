package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.ClasseRestController;
import apii.apii.apii.Services.ClasseServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.ClasseRequestDto;
import apii.apii.apii.dto.response.AppUserResponseDto;
import apii.apii.apii.dto.response.ClasseResponseDto;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.services.ClasseService;
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
public class ClasseRestControllerImpl implements ClasseRestController {
    private final ClasseService classeService;
    private final ClasseServiceRest classeServiceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerClasses(int page, int size, String keyword) {
        Page<Classe> classes=classeService.getAllClassesByLibelleAndActiveTrue (keyword,PageRequest.of(page,size));
        Page<ClasseResponseDto> dataDto = classes.map(ClasseResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> saveAnnee(ClasseRequestDto classeRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            classeServiceRest.add(classeRequestDto);
            response= RestResponse.response(classeRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
