package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(value = 3)
@RequiredArgsConstructor
public class RoleFixtures implements CommandLineRunner {
    private final AppRoleRepository appRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 5; i++) {
            AppRole role=new AppRole();
           role.setActive(true);
            List<AppUser> users=new ArrayList<>();
            //role.setUsers(users);
            if (i==1){
                role.setRoleName("ETUDIANT");
            }
            if (i==2){
                role.setRoleName("PROFESSEUR");
            }
            if (i==3){
                role.setRoleName("AC");
            }
            if (i==4){
                role.setRoleName("RP");
            }
            appRoleRepository.save(role);
        }
    }
}
