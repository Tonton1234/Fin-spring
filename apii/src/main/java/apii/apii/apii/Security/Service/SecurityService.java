package apii.apii.apii.Security.Service;

import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;

public interface SecurityService {

    AppUser getUserByLogin(String login);
    AppUser saveUser(AppUser user);
    AppRole saveRole(String role_name);
    void AddRoleToUser(String login, String role_name);
    void removeRoleToUser(String login, String role_name);
}
