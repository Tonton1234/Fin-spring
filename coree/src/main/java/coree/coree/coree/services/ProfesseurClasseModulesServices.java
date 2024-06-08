package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfesseurClasseModulesServices extends Service<ProfesseurClasseModules,Long>{
    Page<ProfesseurClasseModules> findProfesseurClasseModulesByActiveTrue(Pageable pageable);
}
