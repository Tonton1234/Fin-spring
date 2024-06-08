package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SemestreService extends Service<Semestre,Long>{
    Page<Semestre> findSemestreByActiveTrue(Pageable pageable);
}
