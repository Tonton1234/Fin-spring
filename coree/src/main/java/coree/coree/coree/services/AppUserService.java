package coree.coree.coree.services;


import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppUserService extends Service<AppUser,Long>{
    Page<AppUser> getAllUsersByActiveTrue(Pageable pageable);
}
