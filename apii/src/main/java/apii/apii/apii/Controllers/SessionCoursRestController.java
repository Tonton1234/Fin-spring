package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.CoursRequestDto;
import apii.apii.apii.dto.request.SessionResquestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface SessionCoursRestController {
    @GetMapping("/sessions")//End Point
    ResponseEntity<Map<Object, Object>> listerSessionsCours(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @GetMapping("sessions/cours/{id}")
    ResponseEntity<Map<Object, Object>> listerSessionsByCours(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @GetMapping("sessions/annuler/{id}")
    ResponseEntity<Map<Object, Object>> annulerSessionsByCours(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @PostMapping("/sessions")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody SessionResquestDto sessionResquestDto, BindingResult bindingResult);
    @GetMapping("/sessions/user/{username}")//End Point
    ResponseEntity<Map<Object, Object>> listerSessionCoursByUsername(@PathVariable(required = true) String username);
}
