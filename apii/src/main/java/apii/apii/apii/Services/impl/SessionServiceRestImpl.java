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
        if (!((int) hourDifference>cours.getNbreHeureRestant()) ){
            cours.setNbreHeurePlanifier((int) hourDifference + cours.getNbreHeurePlanifier());
            cours.setNbreHeureRestant(cours.getNbreHeureRestant()-(int) hourDifference);
            coursRepository.save(cours);
            sessionCoursRepository.save(sessionCours);
        }

    }

}
