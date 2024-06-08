package coree.coree.coree.services;

import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoursService extends Service<Cours,Long>{
    Page<Cours> getAllCoursByActiveTrue(Pageable pageable);
    Cours getById(Long ig);
    Page<Cours> getAllCoursByActiveTrueAndEncours(Pageable pageable);
    Page<Cours> getAllCoursByActiveTrueAndTerminer(Pageable pageable);

}
