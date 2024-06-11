package springg.springg.springg.Security.Service.impl;

import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springg.springg.springg.Security.Service.SecurityService;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
   private final AppRoleRepository appRoleRepository;
   private final AppUserRepository appUserRepository;
    @Override
    public AppUser getUserByLogin(String login) {
        return appUserRepository.findByUsername(login);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(String role_name) {
        AppRole role=new AppRole(role_name);
        appRoleRepository.save(role);
        return null;
    }

    @Override
    public void AddRoleToUser(String login, String role_name) {
            AppRole role = appRoleRepository.findByRoleName(role_name);
            if(role ==null)throw new RuntimeException("Role not exist");
            AppUser user=appUserRepository.findByUsername(login);
            if(user ==null)throw new RuntimeException("User not exist");
             user.getRoles().add(role);
            appUserRepository.save(user);
    }

    @Override
    public void removeRoleToUser(String login, String role_name) {


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser user=appUserRepository.findByUsername(username);
        System.out.println(username);
        System.out.println(user);
        if(user ==null)throw new RuntimeException("User not exist");

        return new User(user.getUsername(),user.getPassword(),
                user.getRoles().stream().map(appRole -> new SimpleGrantedAuthority(appRole.getRoleName())).toList());
    }
}
