package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleService extends Service<Module,Long>{
    List<Module> findAllByActive();
    Module findByLibelle(String libelle);
    Page<Module> findModuleByActiveTrue(Pageable pageable);
}
