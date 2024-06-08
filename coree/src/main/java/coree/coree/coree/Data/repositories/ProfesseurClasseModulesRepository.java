package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurClasseModulesRepository extends JpaRepository<ProfesseurClasseModules,Long> {
    Page<ProfesseurClasseModules> findProfesseurClasseModulesByActiveTrue(Pageable pageable);
    List<ProfesseurClasseModules> findProfesseurClasseModulesByModulesAndActiveTrue(Module module);
    Page<ProfesseurClasseModules> findProfesseurClasseModulesByModulesAndActiveTrue(Module module, Pageable pageable);
    Page<ProfesseurClasseModules> findProfesseurClasseModulesByProfesseurAndActiveTrue(Professeur professeur, Pageable pageable);
    List<ProfesseurClasseModules> findProfesseurClasseModulesByModulesAndProfesseurAndActiveTrue(Module module,Professeur prof);
    Page<ProfesseurClasseModules> findProfesseurClasseModulesByModulesAndProfesseurAndActiveTrue(Module module,Professeur prof, Pageable pageable);
    ProfesseurClasseModules findProfesseurClasseModulesByProfesseurAndClasse(Professeur prof, Classe cl);

}
