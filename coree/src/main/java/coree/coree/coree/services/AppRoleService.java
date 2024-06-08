package coree.coree.coree.services;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppRoleService extends Service<AppRole,Long>{
    Page<AppRole> getAllRoleByActiveTrue(Pageable pageable);
}
