package apii.apii.apii.Controllers;

import apii.apii.apii.dto.request.ModuleRequestDto;
import apii.apii.apii.dto.request.ProfesseurClasseModuleRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface ProfesseurClasseModulesRestResponse {
    @GetMapping("/professeurClasseModules")//End Point
    ResponseEntity<Map<Object, Object>> listerProfesseurClasseModules(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam( defaultValue = "") String keyword
    );
    @GetMapping("professeurClasseModules/professeur/{id}")
    ResponseEntity<Map<Object, Object>> listerByProf(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @GetMapping("professeurClasseModules/module/{id}")
    ResponseEntity<Map<Object, Object>> listerByModule(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @GetMapping("professeurClasseModules/professeurr/{idProf}")
    ResponseEntity<Map<Object, Object>> listerByModuleAndProf(@PathVariable Long idProf,@RequestParam(defaultValue = "2") Long idMod, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @PostMapping("/professeurClasseModules")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody ProfesseurClasseModuleRequestDto professeurClasseModuleRequestDto, BindingResult bindingResult);
}
