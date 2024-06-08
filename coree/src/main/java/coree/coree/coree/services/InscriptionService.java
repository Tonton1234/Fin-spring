package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InscriptionService extends Service<Inscription,Long> {
    Page<Inscription> findInscriptionByActiveTrue(Pageable pageable);
}
