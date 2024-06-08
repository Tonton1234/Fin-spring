package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.AppUser;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppRoleResponseDto {
   private Long id;

    private Boolean active;
    private String roleName;

    public static AppRoleResponseDto toDto(AppRole role){
        return AppRoleResponseDto
                .builder()
                .id(role.getId())
                .active(role.getActive())
                .roleName(role.getRoleName())
                .build();
    }

}
