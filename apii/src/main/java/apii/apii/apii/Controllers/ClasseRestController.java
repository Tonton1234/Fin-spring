package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.AnneeScolaireRequestDto;
import apii.apii.apii.dto.request.ClasseRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ClasseRestController {
    @GetMapping("/classes")//End Point
    ResponseEntity<Map<Object, Object>> listerClasses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @PostMapping("/classes")
    ResponseEntity<Map<Object, Object>> saveAnnee(@Valid @RequestBody ClasseRequestDto classeRequestDto, BindingResult bindingResult);

}
