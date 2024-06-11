package springg.springg.springg.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

public interface SessionCoursController {

    @GetMapping(value = "/admin/cours")
    String listerCours(Model model,
                             @RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "6")int size,
                       @RequestParam(required = false) String date,
                       @RequestParam(required = false) String module,
                       @RequestParam(required = false) String professeur
                             ) throws ParseException;
    @GetMapping(value = "/admin/home")
    String home(Model model,
                       @RequestParam(defaultValue = "0")int page,
                       @RequestParam(defaultValue = "6")int size

    ) throws ParseException;
    @GetMapping(value = "/admin/liste_cours")
    String Cours(Model model,
                       @RequestParam(defaultValue = "0")int page,
                       @RequestParam(defaultValue = "6")int size,
                 @RequestParam(required = false) String date,
                 @RequestParam(required = false) String module,
                   @RequestParam(required = false) String professeur

    ) throws ParseException;
    @GetMapping("/admin/valider/session/{id}")
    String Valider(Model model,
                                @PathVariable Long id,
                                @RequestParam(required = false) String date,
                                @RequestParam(defaultValue = "0")int page,
                                @RequestParam(defaultValue = "6")int size) throws ParseException;
}
