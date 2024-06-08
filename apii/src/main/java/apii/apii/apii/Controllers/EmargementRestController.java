package apii.apii.apii.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface EmargementRestController {
    @GetMapping("/emargement")//End Point
    ResponseEntity<Map<Object, Object>> listerEmargements(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
}
