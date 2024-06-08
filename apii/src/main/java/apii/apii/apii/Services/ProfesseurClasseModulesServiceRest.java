package apii.apii.apii.Services;

import apii.apii.apii.dto.request.ProfesseurClasseModuleRequestDto;
import apii.apii.apii.dto.request.ProfesseurRequestDto;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfesseurClasseModulesServiceRest extends serviceRest<ProfesseurClasseModuleRequestDto,Long>{
    Page<ProfesseurClasseModules> getAllByModule(Module module, Pageable pageable);
    Page<ProfesseurClasseModules> getAllByProfesseur(Professeur professeur, Pageable pageable);
    Page<ProfesseurClasseModules> getAllByModuleAndProf(Module module, Professeur professeur, Pageable pageable);
}
