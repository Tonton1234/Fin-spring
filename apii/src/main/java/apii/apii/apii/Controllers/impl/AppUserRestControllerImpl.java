package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.AppUserRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.AppRoleResponseDto;
import apii.apii.apii.dto.response.AppUserResponseDto;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.services.AppUserService;
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
public class AppUserRestControllerImpl implements AppUserRestController {
    private final AppUserService appUserService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerUsers(int page, int size, String keyword) {
        Page<AppUser> users=appUserService.getAllUsersByActiveTrue(PageRequest.of(page,size));
        Page<AppUserResponseDto> dataDto = users.map(AppUserResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
