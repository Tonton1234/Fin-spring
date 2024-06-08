package springg.springg.springg.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

public interface EmmargementController {
    @GetMapping("/admin/emmargement")
    String listerEmmargement(Model model,
                        @RequestParam(defaultValue = "0")int page,
                        @RequestParam(defaultValue = "8")int size,
                             @RequestParam(required = false) String date
                      ) throws ParseException;
    @GetMapping("/admin/valider/abscence/{id}")
    String Valider(Model model,
                   @PathVariable Long id,
                   @RequestParam(required = false) String date,
                   @RequestParam(defaultValue = "0")int page,
                   @RequestParam(defaultValue = "6")int size) throws ParseException;

    @GetMapping("/admin/annuler/abscence/{id}")
    String annuler(Model model,
                   @PathVariable Long id,
                   @RequestParam(required = false) String date,
                   @RequestParam(defaultValue = "0")int page,
                   @RequestParam(defaultValue = "6")int size) throws ParseException;
}
