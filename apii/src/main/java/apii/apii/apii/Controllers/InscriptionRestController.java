package apii.apii.apii.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface InscriptionRestController {
    @GetMapping("/inscriptions")//End Point
    ResponseEntity<Map<Object, Object>> listerInscriptions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
}
