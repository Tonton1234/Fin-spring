package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.CoursRestController;
import apii.apii.apii.Services.CoursServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.CoursRequestDto;
import apii.apii.apii.dto.response.ClasseResponseDto;
import apii.apii.apii.dto.response.CourResponseDto;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.services.CoursService;
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
import java.util.Objects;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class CoursRestControllerImpl implements CoursRestController {
    private final CoursService coursService;
    private final CoursServiceRest coursServiceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerCours(int page, int size, String keyword) {
        Page<Cours> cours=null;

        if (Objects.equals(keyword, "Planifier")){
            System.out.println("ok");
            cours= cours=coursService.getAllCoursByActiveTrueAndEncours(PageRequest.of(page,size));
        }
        if (Objects.equals(keyword, "Terminer")){
            System.out.println("fin");
            cours=coursService.getAllCoursByActiveTrueAndTerminer(PageRequest.of(page,size));
        }
        if (Objects.equals(keyword, "")){
            cours=coursService.getAllCoursByActiveTrue (PageRequest.of(page,size));
        }
         assert cours != null;
        Page<CourResponseDto> dataDto = cours.map(CourResponseDto::toDto);

        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(CoursRequestDto coursRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{

            coursServiceRest.add(coursRequestDto);
            response= RestResponse.response(coursRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
