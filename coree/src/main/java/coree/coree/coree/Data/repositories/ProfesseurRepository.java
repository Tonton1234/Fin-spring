package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Professeur findByNom(String nom);
    Professeur findByUsername(String username);

    Professeur findById(int i);

    Professeur findProfesseurById(Long i);
    Page<Professeur> findProfesseurByActiveTrue(Pageable pageable);

}
