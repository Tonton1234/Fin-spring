package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.EtudiantRequestDto;
import apii.apii.apii.dto.request.SalleRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface SalleRestResponse {
    @GetMapping("/salles")//End Point
    ResponseEntity<Map<Object, Object>> listerSalles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @PostMapping("/salles")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody SalleRequestDto salleRequestDto, BindingResult bindingResult);

}
