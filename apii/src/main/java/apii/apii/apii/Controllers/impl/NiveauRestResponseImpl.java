package apii.apii.apii.Controllers.impl;

import apii.apii.apii.Controllers.NiveauRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class NiveauRestResponseImpl implements NiveauRestResponse {
    @Override
    public ResponseEntity<Map<Object, Object>> listerNiveaux(int page, int size, String keyword) {
        return null;
    }
}
