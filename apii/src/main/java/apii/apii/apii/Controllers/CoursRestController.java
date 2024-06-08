package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.CoursRequestDto;
import apii.apii.apii.dto.request.EtudiantRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface CoursRestController {
    @GetMapping("/cours")//End Point
    ResponseEntity<Map<Object, Object>> listerCours(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @PostMapping("/cours")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody CoursRequestDto coursRequestDto, BindingResult bindingResult);

}
