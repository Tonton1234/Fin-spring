package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.RP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPRepository extends JpaRepository<RP,Long> {
    AppUser findByUsername(String username);
}
