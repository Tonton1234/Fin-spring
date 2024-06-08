package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.ModuleRestController;
import apii.apii.apii.Services.ModuleServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.ModuleRequestDto;
import apii.apii.apii.dto.response.InscriptionResponseDto;
import apii.apii.apii.dto.response.ModuleResponseDto;
import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.services.InscriptionService;
import coree.coree.coree.services.ModuleService;
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
public class ModuleRestControllerImpl implements ModuleRestController {
    private final ModuleService moduleService;
    private final ModuleServiceRest moduleServiceRest;
    @Override
    public ResponseEntity<Map<Object, Object>> listerModules(int page, int size, String keyword) {
        Page<Module> modules=moduleService.findModuleByActiveTrue (PageRequest.of(page,size));
        Page<ModuleResponseDto> dataDto = modules.map(ModuleResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(ModuleRequestDto moduleRequestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            moduleServiceRest.add(moduleRequestDto);
            response= RestResponse.response(moduleRequestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
