package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.services.AnneeScolaireService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class AnneeScolaireFixtures implements CommandLineRunner {
    private final AnneeScolaireService anneeScolaireService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 3; i++) {
            AnneeScolaire anneeScolaire=new AnneeScolaire();
            anneeScolaire.setActive(true);
            if (i==0){
                anneeScolaire.setLibelle("2021-2022");
            }
            if (i==1){
                anneeScolaire.setLibelle("2022-2023");
            }
            if (i==2){
                anneeScolaire.setLibelle("2023-2024");
            }
            anneeScolaireService.save(anneeScolaire);
        }
    }
}
