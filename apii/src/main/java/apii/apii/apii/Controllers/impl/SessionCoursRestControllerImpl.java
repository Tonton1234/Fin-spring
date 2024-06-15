package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.SessionCoursRestController;
import apii.apii.apii.Services.SessionServiceRest;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.request.SessionResquestDto;
import apii.apii.apii.dto.response.DtoRequestCalendar;
import apii.apii.apii.dto.response.SemestreResponseDto;
import apii.apii.apii.dto.response.SessionCoursResponseDto;
import apii.apii.apii.dto.response.SessionResponseDto;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.entities.SessionCours;
import coree.coree.coree.Data.repositories.AppUserRepository;
import coree.coree.coree.services.SemestreService;
import coree.coree.coree.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
public class SessionCoursRestControllerImpl implements SessionCoursRestController {
    private final SessionCoursService sessionCoursService;
    private final SessionServiceRest serviceRest;
    private final AppUserRepository appUserRepository;
    @Override
    public ResponseEntity<Map<Object, Object>> listerSessionsCours(int page, int size, String keyword) {
        List<SessionCours> ss=sessionCoursService.getAll();
        Page<SessionCours> sec=convertListToPage(ss,page,size);
        Page<SessionCours> sessionCours=sessionCoursService.getAllByActiveTrue (PageRequest.of(page,size));
        Page<SessionResponseDto> dataDto = sessionCours.map(SessionResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    public Page<SessionCours> convertListToPage(List<SessionCours> list, int pageNumber, int pageSize) {
        int start = pageNumber * pageSize;
        int end = Math.min((pageNumber + 1) * pageSize, list.size());

        List<SessionCours> content = list.subList(start, end);

        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), list.size());
    }


    @Override
    public ResponseEntity<Map<Object, Object>> listerSessionsByCours(Long id, int page, int size) {
        Page<SessionCours> sessionCours=sessionCoursService.getAllByCoursId (id,PageRequest.of(page,size));
        Page<SessionResponseDto> dataDto = sessionCours.map(SessionResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> annulerSessionsByCours(Long id, int page, int size) {
        System.out.println("jkesbfj");
        SessionCours sessionCourss=sessionCoursService.getById(id);
        sessionCourss.setActive(false);
        System.out.println(sessionCourss);

        sessionCoursService.save(sessionCourss);
        Page<SessionCours> sessionCours=sessionCoursService.getAllByActiveTrue (PageRequest.of(page,size));
        Page<SessionResponseDto> dataDto = sessionCours.map(SessionResponseDto::toDto);
        Map<Object, Object>  model= RestResponse.paginateResponse(dataDto.getContent(),new int[dataDto.getTotalPages()],dataDto.getNumber(),dataDto.getTotalElements(),dataDto.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Map<Object, Object>> save(SessionResquestDto sessionResquestDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{

            serviceRest.add(sessionResquestDto);
            response= RestResponse.response(sessionResquestDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerSessionCoursByUsername(String username) {
        AppUser user = appUserRepository.findByUsername(username);

        /*boolean in = false;
        for (AppRole r : user.getRoles()){
            if(r.getRoleName().equals(professeur)){
                in = true;
            }
        }*/
        List<SessionCours> sessionCoursList = sessionCoursService.getAllByProfesseur(user);
        List<DtoRequestCalendar> dataDto = sessionCoursList.stream().map(DtoRequestCalendar::toDto).toList();
        System.out.println(RestResponse.response(dataDto,HttpStatus.OK));
        return new ResponseEntity<>(RestResponse.response(dataDto,HttpStatus.OK), HttpStatus.OK);
    }

}
