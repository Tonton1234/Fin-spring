package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    Semestre findById(int i);
    Semestre findSemestreById(Long i);

    List<Semestre> findAllById(int i);
    Page<Semestre> findSemestreByActiveTrue(Pageable pageable);
}
