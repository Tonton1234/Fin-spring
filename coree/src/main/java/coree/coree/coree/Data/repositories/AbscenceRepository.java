package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Abscence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbscenceRepository extends JpaRepository<Abscence,Long> {
    Page<Abscence> getAllByActiveTrue (Pageable pageable);
}
