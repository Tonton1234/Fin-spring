package springg.springg.springg.Security.controllers.impl;


import coree.coree.coree.Data.entities.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import springg.springg.springg.Security.Service.SecurityService;
import springg.springg.springg.Security.controllers.SecurityController;

@Controller
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {
    private  final SecurityService securityService;
    @Override
    public String login(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("ADMIN")==0)){
            return "redirect:/admin/cours";
        }

        if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("AC")==0)){
            AppUser user =  securityService.getUserByLogin(userDetails.getUsername());
            return "redirect:/admin/emmargement"+user.getId();
        }

        return "redirect:/login";
    }
}
