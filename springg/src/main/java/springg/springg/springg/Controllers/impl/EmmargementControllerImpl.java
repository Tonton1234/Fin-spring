package springg.springg.springg.Controllers.impl;

import coree.coree.coree.Data.entities.Abscence;
import coree.coree.coree.Data.entities.Emargement;
import coree.coree.coree.services.EmmargementService;
import coree.coree.coree.services.Impl.AbscenceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springg.springg.springg.Controllers.EmmargementController;
import springg.springg.springg.dto.Response.EmargementResponseDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class EmmargementControllerImpl implements EmmargementController {
    private final EmmargementService emmargementService;
    private final AbscenceServiceImpl abscenceService;
    @Override
    public String listerEmmargement(Model model, int page, int size, String date) throws ParseException {
        Page<Emargement> emmargements;
        if (date != null && !date.equals("")){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dateVrai = formatter.parse(date);
            LocalDate localDate = dateVrai.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            emmargements=emmargementService.getAllEmmargementByActiveTrueAndDate(localDate,PageRequest.of(page,size));
        }else{
            emmargements=emmargementService.getAllEmmargementByActiveTrue(PageRequest.of(page,size));
        }
        Page<EmargementResponseDto> emmargementDtos= emmargements.map(EmargementResponseDto::toDto);
        model.addAttribute("emmargements",emmargementDtos.getContent());
        model.addAttribute("pages",new int[emmargementDtos.getTotalPages()]);
        model.addAttribute("date",date);
        model.addAttribute("currentPage",page);
        model.addAttribute("nbrePage",emmargementDtos.getTotalPages());

        return "Emmargement/listerEmmargement";
    }

    @Override
    public String Valider(Model model, Long id, String date, int page, int size) throws ParseException {
        int idd = Math.toIntExact(id);
        Emargement emmargement=emmargementService.getById(idd);
        if (emmargement==null){
            return "redirect:/admin/emmargement";
        }

        Abscence absence=new Abscence();
        absence.setDate(emmargement.getDate());
        absence.setEtudiant(emmargement.getEtudiant());
        absence.setSessionCours(emmargement.getSessionCours());
        absence.setActive(true);
        absence.setPresence(emmargement.getPresent());
        emmargement.setActive(false);
        abscenceService.save(absence);
        emmargementService.save(emmargement);

        return "redirect:/admin/emmargement";
    }

    @Override
    public String annuler(Model model, Long id, String date, int page, int size) throws ParseException {
        int idd = Math.toIntExact(id);
        Emargement emmargement=emmargementService.getById(idd);
        if (emmargement==null){
            return "redirect:/admin/emmargement";
        }
        System.out.println(emmargement.getEtudiant().getNom());
        System.out.println(emmargement);
        Abscence absence=new Abscence();
        absence.setDate(emmargement.getDate());
        absence.setEtudiant(emmargement.getEtudiant());
        absence.setSessionCours(emmargement.getSessionCours());
        emmargement.setPresent(!emmargement.getPresent());
        absence.setActive(true);
        absence.setPresence(emmargement.getPresent());
        System.out.println(absence);
        emmargement.setActive(false);
       /* abscenceService.save(absence);*/
        emmargementService.save(emmargement);
        return "redirect:/admin/emmargement";
    }
}
