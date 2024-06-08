package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.repositories.EmargementRepository;
import coree.coree.coree.Data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
@Order(9)
public class EmmargementFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final EmargementRepository emargementRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 2; i++) {

            SessionCours sessionCours=sessionCoursRepository.findById(i);
            Cours cours=sessionCours.getCours();
            List<Classe> classes=cours.getClasses();
            List<Semestre> semestres=cours.getSemestres();
            //System.out.println(semestres);
            List<Etudiant> etudiants=new ArrayList<>();
            classes.forEach(element -> {
                element.getInscriptions().forEach(ins->{
                    if (ins.getAnneeScolaire().getActive()){
                        etudiants.add(ins.getEtudiant());
                    }
                });
            });
            etudiants.forEach(etudiant -> {
                Emargement emargement=new Emargement();
                emargement.setDate(sessionCours.getDate());
                emargement.setEtudiant(etudiant);
                emargement.setSessionCours(sessionCours);
                emargement.setActive(true);
                if (etudiant.getId() % 2==0){
                    emargement.setActive(true);
                    emargement.setPresent(true);
                }
                emargementRepository.save(emargement);
            });


        }

    }
}
