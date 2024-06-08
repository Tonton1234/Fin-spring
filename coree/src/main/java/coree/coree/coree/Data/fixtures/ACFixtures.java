package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Ac;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.repositories.ACRepository;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
@RequiredArgsConstructor
@Order(4)
public class ACFixtures implements CommandLineRunner {
    private final ACRepository acRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();
        role.add(appRoleRepository.findAllById(3));
        //List<AppUser> user=new ArrayList<>();
       // user.add((AppUser)role.get(0).getUsers());
        for (int i = 1; i < 3; i++) {
            Ac ac =new Ac();
            ac.setNom("nom"+i);
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("AC"+i);
            ac.setRoles(role);
            ac.setActive(true);
           // user.add(ac);
           // role.get(0).setUsers(user);
            acRepository.save(ac);
        }
    }
}
