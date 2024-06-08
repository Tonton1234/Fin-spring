package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.SessionCours;

import coree.coree.coree.Data.repositories.CoursRepository;
import coree.coree.coree.Data.repositories.SallesCoursRepository;
import coree.coree.coree.Data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

//@Component
@Order(value = 8)
@RequiredArgsConstructor
public class SessionCoursFixtures implements CommandLineRunner {

    private final SallesCoursRepository sallesCoursRepository;
    private final SessionCoursRepository sessionCoursRepository;
    private  final CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {

                SessionCours sessionCours=new SessionCours();
                sessionCours.setActive(true);
                sessionCours.setDate(LocalDate.now());
                sessionCours.setEtat(EtatSessionCours.Planifier);
                sessionCours.setLieu(EtatLieu.Enligne);
                sessionCours.setHeureDebut(LocalTime.of(12,00,00));
                sessionCours.setHeureFin(LocalTime.of(17,00,00));
             System.out.println("ok");
                System.out.println(coursRepository.findAll());
                Cours cours=coursRepository.findById(i);
                sessionCours.setCours(cours);
                sessionCours.setLibelle(cours.getModule().getLibelle() + ' '+ sessionCours.getDate());
               sessionCours.setProfesseur(cours.getProfesseur());
               sessionCours.setModule(cours.getModule());
                if(i%2==0){
                    sessionCours.setLieu(EtatLieu.Présentiel);
                    sessionCours.setSallescours(sallesCoursRepository.findById(i));
                }
                else {
                    sessionCours.setLieu(EtatLieu.Enligne);
                }
                sessionCoursRepository.save(sessionCours);
        }
    }
}
