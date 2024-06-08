package springg.springg.springg.Security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

public interface SecurityController {
    @GetMapping("/")
    String login(@AuthenticationPrincipal UserDetails userDetails);
}
