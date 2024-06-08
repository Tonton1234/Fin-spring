package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.repositories.*;
import coree.coree.coree.services.*;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//@Component
@RequiredArgsConstructor
@Order(7)
public class CoursFixtures implements CommandLineRunner {

    private final CoursService coursService;
    private final ModuleRepository moduleService;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ClasseRepository classeRepository;
    private final ProfesseurRepository professeurRepository;
    private final SallesService sallesService;
    private final SemestreRepository semestreService;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {
                Cours cours = new Cours();
                List<Classe> classes=classeRepository.findAll();
                //  entityManager.merge(classes);

                cours.setClasses(classes);
                //  System.out.println(moduleService.findById(3).getLibelle());
                cours.setModule(moduleService.findById(i));
            System.out.println(moduleService.findById(i));
                cours.setAnneeScolaire(anneeScolaireRepository.findById(3));
                cours.setEtat(EtatCours.Encours);
                cours.setActive(true);
                cours.setNbreHeureGlobal(30);
                cours.setProfesseur(professeurRepository.findByNom("nom"+i));
               cours.setSemestres(semestreService.findAll());
                coursService.save(cours);

        }
    }
}
