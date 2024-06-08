package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantRelationResponseDto {
    private Long id;
    private Boolean active;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private List<AppRoleResponseDto> roles;
    private String matricule;
    private String tuteur;


    public static EtudiantRelationResponseDto toDto(Etudiant etudiant){
        return EtudiantRelationResponseDto
                .builder()
                .id(etudiant.getId())
                .active(etudiant.getActive())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .username(etudiant.getUsername())
                .password(etudiant.getPassword())
                .roles(etudiant.getRoles().stream().map(AppRoleResponseDto::toDto).toList())
                .matricule(etudiant.getMatricule())
                .tuteur(etudiant.getTuteur())

                .build();
    }
}
