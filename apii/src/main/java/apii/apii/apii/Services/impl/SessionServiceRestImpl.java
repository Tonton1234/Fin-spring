package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.SessionServiceRest;
import apii.apii.apii.dto.request.SessionResquestDto;
import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import java.time.format.DateTimeFormatter;
@Service
@RequiredArgsConstructor
public class SessionServiceRestImpl implements SessionServiceRest {
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final SemestreRepository semestreRepository;
    private final CoursRepository coursRepository;
    private final SallesCoursRepository sallesCoursRepository;
    private final SessionCoursRepository sessionCoursRepository;
    public Boolean ok=null;
    @Override
    public void add(SessionResquestDto dto) {
        Cours cours=coursRepository.findCoursById(dto.getCours());

        String dateString = dto.getDate();
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatterD);
        String heureDebutt = dto.getHeureDebut();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime heureDebut = LocalTime.parse(heureDebutt, formatter);
        String heureFinn = dto.getHeureFin();
        LocalTime heureFin = LocalTime.parse(heureFinn, formatter);
        Module module=cours.getModule();
        Professeur professeur=cours.getProfesseur();
        SallesDeCours salle=null;
        EtatLieu lieu=null;
        if (dto.getSalle()==0){
             lieu=EtatLieu.Enligne;
        }else {
             lieu=EtatLieu.Présentiel;
            salle=sallesCoursRepository.findSallesDeCoursById(dto.getSalle());
        }
        Duration duration = Duration.between(heureDebut, heureFin);
        long hourDifference = duration.toHours();

        String libelle=cours.getModule().getLibelle() + ' '+ date;
        SessionCours sessionCours=new SessionCours();
        sessionCours.setDate(date);
        sessionCours.setHeureDebut(heureDebut);
        sessionCours.setHeureFin(heureFin);
        sessionCours.setCours(cours);
        sessionCours.setModule(module);
        sessionCours.setEtat(EtatSessionCours.Planifier);
        sessionCours.setProfesseur(professeur);
        sessionCours.setActive(true);
        sessionCours.setSallescours(salle);
        sessionCours.setLieu(lieu);

        sessionCours.setLibelle(libelle);
        ok=true;
        if (!((int) hourDifference>cours.getNbreHeureRestant()  ||(heureDebut).isAfter( LocalTime.of(17, 0)) ||
                heureDebut.isBefore( LocalTime.of(7, 0))
                ||(heureFin).isAfter( LocalTime.of(20, 0)) ||
                heureFin.isBefore( LocalTime.of(10, 0)) )){
            sessionCoursRepository.findAllByProfesseurAndActiveTrue(professeur).forEach(element -> {
                LocalTime.of(17, 0);
               if ( element.getDate().compareTo(date)==0){
                   System.out.println(element.getDate());
                   System.out.println(date);
                   LocalTime.of(17, 0);
                   if ((heureDebut.isAfter(element.getHeureDebut()) && heureDebut.isBefore(element.getHeureFin()))
                           || (heureFin).isAfter(element.getHeureDebut())  && heureFin.isBefore(element.getHeureFin())
                           ||(heureFin).isAfter(element.getHeureDebut())  && heureDebut.isBefore(element.getHeureDebut())


                   ){
                       ok=false;
                       System.out.println("IMPOSSIBLE DE CREER");
                       System.out.println("IMPOSSIBLE DE CREER");
                       System.out.println("IMPOSSIBLE DE CREER");
                       System.out.println("IMPOSSIBLE DE CREER");
                   }else {
                     
                   }
               }
            });
            if (ok){
                cours.setNbreHeurePlanifier(cours.getNbreHeurePlanifier()+(int) hourDifference);
                cours.setNbreHeureRestant(cours.getNbreHeureRestant()-(int) hourDifference);
                sessionCoursRepository.save(sessionCours);
                coursRepository.save(cours);
                System.out.println(ok);
            }

        }

    }

}
