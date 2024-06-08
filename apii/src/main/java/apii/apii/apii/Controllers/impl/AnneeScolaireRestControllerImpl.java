package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.AnneeScolaireRestController;
import apii.apii.apii.Services.AnneeScolaireRequestService;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.AnneeScolaireRequestDto;
import apii.apii.apii.dto.response.AnneeScolaireResponseDto;
import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.services.AnneeScolaireService;
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
public class AnneeScolaireRestControllerImpl implements AnneeScolaireRestController {
    private final AnneeScolaireService anneeScolaireService;
    private final AnneeScolaireRequestService anneeScolaireRequestService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerAnneeScolaire(int page, int size, String keyword) {
        Page<AnneeScolaire> anneeScolaires=anneeScolaireService. getAllAnneeScolaire(PageRequest.of(page,size));
        Page<AnneeScolaireResponseDto> dataDto = anneeScolaires.map(AnneeScolaireResponseDto::toDto);
        dataDto.forEach(element -> {
            System.out.println(element.getLibelle());
        });
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(),HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Map<Object, Object>> saveAnnee(AnneeScolaireRequestDto anneeScolaireRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            anneeScolaireRequestService.add(anneeScolaireRequestDto);
            response= RestResponse.response(anneeScolaireRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
