package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.services.SallesService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@Order(value = 3)
@RequiredArgsConstructor
public class SalleFixtures implements CommandLineRunner {
    private final SallesService sallesService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <3 ; j++) {
                SallesDeCours salle=new SallesDeCours();
                salle.setNom("salle"+i+j);
                salle.setNumero(""+i+j);
                salle.setNbrePlaces(10*(i+j));
                salle.setActive(true);
                sallesService.save(salle);
            }
        }
    }
}
