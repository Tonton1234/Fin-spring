package apii.apii.apii.security.controllers.impl;



import apii.apii.apii.dto.RestResponse;
import apii.apii.apii.security.controllers.SecurityController;
import apii.apii.apii.security.controllers.dtos.AuthenticationRequestDto;
import apii.apii.apii.security.controllers.dtos.TokenReponseDto;
import apii.apii.apii.security.services.SecurityService;
import apii.apii.apii.security.services.impl.JwtService;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.repositories.AppUserRepository;
import jakarta.persistence.DiscriminatorColumn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
@Slf4j
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AppUserRepository appUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public ResponseEntity<Map<Object, Object>> login(AuthenticationRequestDto authenticationRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        AppUser user=appUserRepository.findByUsername(authenticationRequestDto.getUsername());
        DiscriminatorColumn discriminatorColumnAnnotation = AppUser.class.getAnnotation(DiscriminatorColumn.class);
        String discriminatorColumnValue = discriminatorColumnAnnotation.columnDefinition();

        String type="ADMIN";
        if(user.getMontype()=="PROFESSEUR"){
            type="PROFESSEUR";
        }

       /* rol.forEach(element -> {
             String type="PROFESSEUR";

            System.out.println(element);
            if (element.getRoleName()=="ADMIN"){
                System.out.println("jesui");
                 type="ADMIN";
            }
        });
*/

        System.out.println(user.getMontype());

        if(authenticate.isAuthenticated()){
            //Generer le token
             String token= jwtService.createToken(authenticationRequestDto.getUsername());
            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .type(user.getMontype())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponse.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponse.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }
}
