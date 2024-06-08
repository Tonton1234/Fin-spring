package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.AnneeScolaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire,Long> {

    AnneeScolaire findById(int i);
    AnneeScolaire findAnneeScolaireByActiveTrue();
    Page<AnneeScolaire> findByActiveTrue(Pageable pageable);
    Page<AnneeScolaire> findAll(Pageable pageable);
}
