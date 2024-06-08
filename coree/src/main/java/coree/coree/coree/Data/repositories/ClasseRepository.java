package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    Classe findById(int i);
    Classe findClasseById(Long id);
    Classe findClasseByLibelle(String libelle);
    List<Classe> findClasseByActiveTrue();
    Page<Classe> findClasseByActiveTrue(Pageable pageable);
    Page<Classe> findClasseByLibelleContainsAndActiveTrue(String libelle,Pageable pageable);
}