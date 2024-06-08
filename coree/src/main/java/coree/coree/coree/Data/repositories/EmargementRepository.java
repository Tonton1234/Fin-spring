package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Emargement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmargementRepository extends JpaRepository<Emargement, Long> {
    //Redéfinition
    List<Emargement> findAll();
    @Override
    Page<Emargement> findAll(Pageable pageable);
    Page<Emargement> findByActiveTrue(Pageable pageable);
    Page<Emargement> findAllByActiveTrueAndDate(LocalDate date,Pageable pageable);
    Emargement findById(int id);
}
