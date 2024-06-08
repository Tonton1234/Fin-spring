package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.Data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(7)
public class ProfesseurClasseModulesFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    private final SemestreRepository semestreRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {
            ProfesseurClasseModules professeurClasseModules=new ProfesseurClasseModules();
            professeurClasseModules.setProfesseur(professeurRepository.findByNom("nom"+i));
            professeurClasseModules.setClasse(classeRepository.findById(i));
            professeurClasseModules.setModules(moduleRepository.findAll());
            professeurClasseModules.setActive(true);
            professeurClasseModules.setSemestre(semestreRepository.findById(i));
            professeurClasseModules.setAnneeScolaire(anneeScolaireRepository.findById(i));

            professeurClasseModulesRepository.save(professeurClasseModules);
        }
    }
}
