package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.Data.repositories.AnneeScolaireRepository;
import coree.coree.coree.Data.repositories.ClasseRepository;
import coree.coree.coree.Data.repositories.EtudiantsRepository;
import coree.coree.coree.Data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

//@Component
@RequiredArgsConstructor
@Order(4)
public class InscriptionFixtures implements CommandLineRunner {
    private final InscriptionRepository inscriptionRepository;
    private final EtudiantsRepository etudiantsRepository;
    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 4; i++) {

            if (i==1){
                for (int j = 1; j < 7; j++) {
                    Inscription inscription=new Inscription();
                    inscription.setActive(true);
                    inscription.setCreateAt(LocalDate.now());
                    inscription.setClasse(classeRepository.findById(i));
                    inscription.setEtudiant(etudiantsRepository.findByNom("nom"+j));
                    inscription.setAnneeScolaire(anneeScolaireRepository.findById(3));
                    inscriptionRepository.save(inscription);
                }
            }
            if (i==2){
                for (int j = 7; j < 13; j++) {
                    Inscription inscription=new Inscription();
                    inscription.setActive(true);
                    inscription.setCreateAt(LocalDate.now());
                    inscription.setClasse(classeRepository.findById(i));
                    inscription.setEtudiant(etudiantsRepository.findByNom("nom"+j));
                    inscription.setAnneeScolaire(anneeScolaireRepository.findById(3));
                    inscriptionRepository.save(inscription);
                }
            }
            if (i==3){
                for (int j = 13; j < 19; j++) {
                    Inscription inscription=new Inscription();
                    inscription.setActive(true);
                    inscription.setCreateAt(LocalDate.now());
                    inscription.setClasse(classeRepository.findById(i));
                    inscription.setEtudiant(etudiantsRepository.findByNom("nom"+j));
                    inscription.setAnneeScolaire(anneeScolaireRepository.findById(3));
                    inscriptionRepository.save(inscription);
                }
            }
        }

    }
}
