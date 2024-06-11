package apii.apii.apii.security.services;


import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUsername(String username);
    AppUser saveUser(String username,String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);
}
