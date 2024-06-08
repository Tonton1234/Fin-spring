package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.ClasseRequestDto;
import apii.apii.apii.dto.request.EtudiantRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface EtudiantRestController {
    @GetMapping("/etudiants")//End Point
    ResponseEntity<Map<Object, Object>> listerEtudiants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @PostMapping("/etudiants")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody EtudiantRequestDto etudiantRequestDto, BindingResult bindingResult);

    @GetMapping("etudiants/cours/{id}")
    ResponseEntity<Map<Object, Object>> listerEtudiantByCours(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @GetMapping("etudiants/classe/{id}")
    ResponseEntity<Map<Object, Object>> listerEtudiantByClasse(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @PostMapping("/etudiants/import")
    @ResponseBody
    ResponseEntity<String> importStudents(@RequestParam("file") MultipartFile file);
}
