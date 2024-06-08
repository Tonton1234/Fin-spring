package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.services.SemestreService;
import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@Order(value = 2)
@RequiredArgsConstructor
public class SemestreFixtures implements CommandLineRunner {
    private final SemestreService semestreService;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 7; i++) {
            Semestre semestre =new Semestre();
            semestre.setActive(true);
            semestre.setLibelle("S"+i);
            if (i==1 || i==2){
                semestre.setNiveau(Niveau.L1);
            }
            if (i==3 || i==4){
                semestre.setNiveau(Niveau.L2);
            }
            if (i==5 || i==6){
                semestre.setNiveau(Niveau.L3);
            }

           semestreService.save(semestre);
        }
    }
}
