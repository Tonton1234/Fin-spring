package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.AppRoleRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.AnneeScolaireResponseDto;
import apii.apii.apii.dto.response.AppRoleResponseDto;
import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.services.AppRoleService;
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
public class AppRoleRestControllerImpl implements AppRoleRestController {
    private final AppRoleService appRoleService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerRoles(int page, int size, String keyword) {
            Page<AppRole> roles=appRoleService.getAllRoleByActiveTrue(PageRequest.of(page,size));
            Page<AppRoleResponseDto> dataDto = roles.map(AppRoleResponseDto::toDto);
            Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
            return new ResponseEntity<>(model, HttpStatus.OK);

        }

}
