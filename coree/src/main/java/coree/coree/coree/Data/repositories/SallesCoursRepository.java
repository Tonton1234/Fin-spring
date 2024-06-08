package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.services.SallesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SallesCoursRepository extends JpaRepository<SallesDeCours,Long> {
    SallesDeCours findById(int i);
    SallesDeCours findSallesDeCoursById(Long id);
    SallesDeCours findFirstByNumero(String numero);
    Page<SallesDeCours> findSallesDeCoursByActiveTrue(Pageable pageable);
}
