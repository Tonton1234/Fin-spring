package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.EmargementRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.CourResponseDto;
import apii.apii.apii.dto.response.EmargementResponseDto;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Emargement;
import coree.coree.coree.services.CoursService;
import coree.coree.coree.services.EmmargementService;
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
public class EmargementRestControllerImpl implements EmargementRestController {
    private final EmmargementService emmargementService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerEmargements(int page, int size, String keyword) {
        Page<Emargement> emargements=emmargementService.getAllEmmargementByActiveTrue (PageRequest.of(page,size));
        Page<EmargementResponseDto> dataDto = emargements.map(EmargementResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
