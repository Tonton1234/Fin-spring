package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Abscence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbscenceService extends Service<Abscence,Long>{
    Page<Abscence> getAllByActiveTrue(Pageable pageable);
}
