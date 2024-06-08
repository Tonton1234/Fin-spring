package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.JustificationRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.InscriptionResponseDto;
import apii.apii.apii.dto.response.JustificationResponseDto;
import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.Data.entities.Justification;
import coree.coree.coree.services.InscriptionService;
import coree.coree.coree.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class JustificationRestControllerImpl implements JustificationRestController {
    private final JustificationService justificationService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerJustification(int page, int size, String keyword) {
        Page<Justification> justifications=justificationService.findJustificationByActiveTrue(PageRequest.of(page,size));
        justifications.forEach(System.out::println);
        Page<JustificationResponseDto> dataDto = justifications.map(JustificationResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
