package coree.coree.coree.services;


import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClasseService extends Service<Classe,Long>{
    Page<Classe> getAllClassesByActiveTrue(Pageable pageable);
    Page<Classe> getAllClassesByLibelleAndActiveTrue(String libelle,Pageable pageable);
    Classe getById(Long id);
}
