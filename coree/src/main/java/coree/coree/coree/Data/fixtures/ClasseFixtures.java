package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.repositories.AnneeScolaireRepository;
import coree.coree.coree.Data.repositories.ModuleRepository;
import coree.coree.coree.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseService classeService;
    private final ModuleRepository moduleRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {
            Classe classe=new Classe();
            if (i==1 ) {
                classe.setLibelle(Filiere.CPD.name() + Niveau.L1.name());
                classe.setNiveau(Niveau.L1);
                classe.setFiliere(Filiere.CPD);
            }
            if (i==2) {
                classe.setLibelle(Filiere.CDSD.name() + Niveau.L2.name());
                classe.setNiveau(Niveau.L2);
                classe.setFiliere(Filiere.CDSD);
            }
            if (i==3) {
                classe.setLibelle(Filiere.GLRS.name() + Niveau.L3.name());
                classe.setNiveau(Niveau.L3);
                classe.setFiliere(Filiere.GLRS);
            }
            classe.setActive(true);
            classeService.save(classe);
        }


    }
}
