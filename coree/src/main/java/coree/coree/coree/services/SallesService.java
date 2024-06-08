package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.SallesDeCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SallesService extends Service<SallesDeCours,Long>{
    Page<SallesDeCours> findSalleByActiveTrue(Pageable pageable);
}
