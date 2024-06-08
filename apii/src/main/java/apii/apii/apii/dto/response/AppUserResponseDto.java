package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserResponseDto {
    private Long id;
    private Boolean active;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private List<AppRoleResponseDto> roles;
    public static AppUserResponseDto toDto(AppUser user){
        return AppUserResponseDto
                .builder()
                .id(user.getId())
                .active(user.getActive())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(AppRoleResponseDto::toDto).toList())
                .build();

    }

}
