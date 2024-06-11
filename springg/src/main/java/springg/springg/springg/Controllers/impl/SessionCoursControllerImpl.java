package springg.springg.springg.Controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.Emargement;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.SessionCours;
import coree.coree.coree.services.ModuleService;
import coree.coree.coree.services.ProfesseurService;
import coree.coree.coree.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springg.springg.springg.Controllers.SessionCoursController;
import springg.springg.springg.dto.Response.EmargementResponseDto;
import springg.springg.springg.dto.Response.SessionCoursResponseDto;
import springg.springg.springg.dto.Response.SessionResponseDto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class SessionCoursControllerImpl implements SessionCoursController {
    private final SessionCoursService sessionCoursService;
    private final ModuleService moduleService;
    private final ProfesseurService professeurService;
    @Override
    public String listerCours(Model model, int page, int size, String date, String module,String professeur) throws ParseException {
        List<SessionCours> sessions =sessionCoursService.getAll();
        System.out.println(module);
        if ((date != null && !date.equals("")) || module!=null || professeur!=null){
            if (module!=null){
                System.out.println(moduleService.findByLibelle(module));
                sessions=sessionCoursService.getAllByModule(moduleService.findByLibelle(module));
            }
            if (professeur!=null){
                System.out.println(professeurService.findByNom(professeur));
                sessions=sessionCoursService.getAllByProfesseur(professeurService.findByNom(professeur));
            }
            if (date != null && !date.equals("")){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date dateVrai = formatter.parse(date);
                LocalDate localDate = dateVrai.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                sessions=sessionCoursService.getAllByDate(localDate);
            }

        }else{
            sessions=sessionCoursService.getAll();
        }
        List<SessionCoursResponseDto> session=sessions.stream().map(s ->SessionCoursResponseDto.toDto(s)).toList();
        model.addAttribute("sessionCours",session);
        return "SessionCours/ListerSessioncours";
    }

    @Override
    public String home(Model model, int page, int size) throws ParseException {
        return "Home/home";
    }

    @Override
    public String Cours(Model model, int page, int size, String date, String module,String professeur) throws ParseException {
        List<SessionCours> sessionCoursList =sessionCoursService.getAll();
        List<Module> modules=moduleService.findAllByActive();
        Page<SessionCours> sessions = null;

        if ((date != null && !date.equals("")) || module!=null || professeur!=null){
            if (module!=null){
                System.out.println(module);
                System.out.println("ok");
                Module modu=moduleService.findByLibelle(module);
                System.out.println(sessionCoursService.getAllByModule(modu,PageRequest.of(page,size)));
                sessions=sessionCoursService.getAllByModule(modu,PageRequest.of(page,size));
            }
            if (professeur!=null){
                System.out.println(professeurService.findByNom(professeur));
                sessions=sessionCoursService.getAllByProfesseur(professeurService.findByNom(professeur),PageRequest.of(page,size));
            }
            if (date != null && !date.equals("")){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date dateVrai = formatter.parse(date);
                LocalDate localDate = dateVrai.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                sessions=sessionCoursService.getAllByDate(localDate,PageRequest.of(page,size));
            }

        }else{
            sessions=sessionCoursService.getAllByActiveTrue(PageRequest.of(page,size));
        }

        Page<SessionResponseDto> sessionCoursDtos= sessions.map(SessionResponseDto::toDto);
        System.out.println(sessionCoursDtos);
        model.addAttribute("modules",modules);
        model.addAttribute("cours",sessionCoursDtos.getContent());
        model.addAttribute("pages",new int[sessionCoursDtos.getTotalPages()]);
        model.addAttribute("date",date);
        model.addAttribute("module",module);
        model.addAttribute("professeur",professeur);
        model.addAttribute("currentPage",page);
        model.addAttribute("nbrePage",sessionCoursDtos.getTotalPages());

        return "SessionCours/Sessioncours";
    }

    @Override
    public String Valider(Model model, Long id, String date, int page, int size) throws ParseException {
        int idd = Math.toIntExact(id);

        SessionCours sessionCours=sessionCoursService.findById(idd);
        System.out.println(sessionCours);
        if(sessionCours == null){
            return "redirect:/sessionCours/Sessioncours";

        }
        sessionCours.setEtat(EtatSessionCours.Valider);
        sessionCours.setActive(false);
        sessionCoursService.save(sessionCours);
        return "redirect:/admin/cours";
    }
}
