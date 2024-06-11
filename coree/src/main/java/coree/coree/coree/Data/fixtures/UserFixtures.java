package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Ac;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class UserFixtures implements CommandLineRunner {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();


        //List<AppUser> user=new ArrayList<>();
        // user.add((AppUser)role.get(0).getUsers());
        for (int i = 4; i < 5; i++) {
            role.add(appRoleRepository.findAllById(i));
            AppUser ac =new AppUser();
            ac.setNom("nom"+i);
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("ADMIN"+i);
            ac.setRoles(role);
            ac.setActive(true);
            // user.add(ac);
            // role.get(0).setUsers(user);
            appUserRepository.save(ac);
        }
    }
}
