package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    Page<Inscription> findInscriptionByActiveTrue(Pageable pageable);
}
