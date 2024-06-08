package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Professeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurRelationResponseDto {

    private Long id;
    private Boolean active;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String grade;
    private String specialite;

    public static ProfesseurRelationResponseDto toDto(Professeur professeur){
        return ProfesseurRelationResponseDto
                .builder()
                .id(professeur.getId())
                .nom(professeur.getNom())
                .prenom(professeur.getPrenom())
                .username(professeur.getUsername())
                .password(professeur.getPassword())
                .active(professeur.getActive())
                .grade(professeur.getGrade())
                .specialite(professeur.getSpecialite())

                .build();
    }


}
