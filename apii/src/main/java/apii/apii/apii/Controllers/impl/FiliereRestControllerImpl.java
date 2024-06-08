package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.FiliereRestController;
import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.dto.response.EtudiantResponseDto;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.services.EtudiantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class FiliereRestControllerImpl implements FiliereRestController {

    @Override
    public ResponseEntity<Map<Object, Object>> listerFilieres(int page, int size, String keyword) {
        return null;
    }
}
