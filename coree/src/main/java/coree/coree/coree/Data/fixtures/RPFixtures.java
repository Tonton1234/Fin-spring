package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Ac;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.RP;
import coree.coree.coree.Data.repositories.ACRepository;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.RPRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
@Order(4)
public class RPFixtures implements CommandLineRunner {
    private final RPRepository rpRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();
        role.add(appRoleRepository.findAllById(4));
        //List<AppUser> user=new ArrayList<>();
       // user.add((AppUser)role.get(0).getUsers());
        for (int i = 1; i < 3; i++) {
            RP ac =new RP();
            ac.setNom("nom"+i);
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("RP"+i);
            ac.setRoles(role);
            ac.setActive(true);
           // user.add(ac);
           // role.get(0).setUsers(user);
            rpRepository.save(ac);
        }
    }
}
