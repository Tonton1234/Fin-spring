package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.AnneeScolaireRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface AnneeScolaireRestController {
    @GetMapping("/anneeScolaire")//End Point
    ResponseEntity<Map<Object, Object>> listerAnneeScolaire(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @PostMapping("/anneeScolaire")
    ResponseEntity<Map<Object, Object>> saveAnnee(@Valid @RequestBody AnneeScolaireRequestDto anneeScolaireRequestDto, BindingResult bindingResult);

}
