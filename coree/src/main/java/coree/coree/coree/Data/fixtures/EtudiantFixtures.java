package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Ac;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.repositories.ACRepository;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.EtudiantsRepository;
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
public class EtudiantFixtures implements CommandLineRunner {
    private final EtudiantsRepository etRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();
        role.add(appRoleRepository.findAllById(1));
        //List<AppUser> user=new ArrayList<>();
       // user.add((AppUser)role.get(0).getUsers());
        for (int i = 1; i < 20; i++) {
            Etudiant ac =new Etudiant();
            ac.setNom("nom"+i);
            ac.setMatricule("mat00"+i);
            ac.setTuteur("Tuteur"+i);
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("Etudiant"+i);
            ac.setRoles(role);
            ac.setActive(true);
           // user.add(ac);
           // role.get(0).setUsers(user);
            etRepository.save(ac);
        }
    }
}
