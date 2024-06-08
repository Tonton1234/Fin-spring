package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EtudiantsService extends Service<Etudiant,Long>{
    Page<Etudiant> findEdutiantByActiveTrue(Pageable pageable);
}
