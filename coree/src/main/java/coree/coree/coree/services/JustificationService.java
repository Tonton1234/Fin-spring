package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Justification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JustificationService extends Service<Justification,Long>{
    Page<Justification> findJustificationByActiveTrue(Pageable pageable);
}
