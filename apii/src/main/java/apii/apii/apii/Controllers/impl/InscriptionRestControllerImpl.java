package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.InscriptionRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.EtudiantResponseDto;
import apii.apii.apii.dto.response.InscriptionResponseDto;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.services.EtudiantsService;
import coree.coree.coree.services.InscriptionService;
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
public class InscriptionRestControllerImpl implements InscriptionRestController {
    private final InscriptionService inscriptionService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerInscriptions(int page, int size, String keyword) {
        Page<Inscription> inscriptions=inscriptionService.findInscriptionByActiveTrue (PageRequest.of(page,size));
        Page<InscriptionResponseDto> dataDto = inscriptions.map(InscriptionResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
