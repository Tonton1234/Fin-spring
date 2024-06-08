package coree.coree.coree.services;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.Emargement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnneeScolaireService extends Service<AnneeScolaire,Long>{
    Page<AnneeScolaire> getAllAnneeScolaireByActiveTrue(Pageable pageable);
    Page<AnneeScolaire> getAllAnneeScolaire(Pageable pageable);


}
