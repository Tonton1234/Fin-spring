package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Ac;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.repositories.ACRepository;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
@Order(1)
public class ProfesseurFixtures implements CommandLineRunner {

    private final ProfesseurRepository pfRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        List<AppRole> role=new ArrayList<>();
        role.add(appRoleRepository.findAllById(2));
        //List<AppUser> user=new ArrayList<>();
       // user.add((AppUser)role.get(0).getUsers());
        for (int i = 1; i < 5; i++) {
            Professeur ac =new Professeur();
            ac.setNom("nom"+i);
            ac.setGrade("Docteur");
            ac.setSpecialite("Informatique");
            ac.setPassword(passwordEncoder.encode("passer"));
            ac.setPrenom("prenom"+i);
            ac.setUsername("Professeur"+i);
            ac.setRoles(role);
            ac.setActive(true);
           // user.add(ac);
           // role.get(0).setUsers(user);
            pfRepository.save(ac);
        }
    }
}
