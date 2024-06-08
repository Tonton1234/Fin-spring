package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfesseurService extends Service<Professeur,Long>{
    Professeur findByNom(String nom);
    Page<Professeur> findProfesseurByActiveTrue(Pageable pageable);
}
