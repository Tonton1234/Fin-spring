package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.SemestreRestResponse;
import apii.apii.apii.Services.SemestreServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.SemestreRequestDto;
import apii.apii.apii.dto.response.SalleResponseDto;
import apii.apii.apii.dto.response.SemestreResponseDto;
import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.services.SallesService;
import coree.coree.coree.services.SemestreService;
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
public class SemestreRestResponseImpl implements SemestreRestResponse {
    private final SemestreService semestreService;
    private final SemestreServiceRest semestreServiceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerSemestres(int page, int size, String keyword) {
        Page<Semestre> semestres=semestreService.findSemestreByActiveTrue (PageRequest.of(page,size));
        Page<SemestreResponseDto> dataDto = semestres.map(SemestreResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(SemestreRequestDto semestreRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            semestreServiceRest.add(semestreRequestDto);
            response= RestResponse.response(semestreRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
