package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    Module findModuleByLibelle(String libelle);
    List<Module> findAllByActiveTrue();
    Module findById(int i);

    Module findModuleById(Long i);
    Module findFirstByLibelle(String libelle);
    Page<Module> findModuleByActiveTrue(Pageable pageable);
}
