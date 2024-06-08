package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurResponseDto {

    private Long id;
    private Boolean active;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String grade;
    private String specialite;
    private List<ProfesseurClasseModulesRelationResponseDto> professeurClasseModules;
    private List<CourRelationResponseDto> cours;
    private List<SessionRelationResponseDto> sessioncours;
    public static ProfesseurResponseDto toDto(Professeur professeur){
        return ProfesseurResponseDto
                .builder()
                .id(professeur.getId())
                .active(professeur.getActive())
                .nom(professeur.getNom())
                .prenom(professeur.getPrenom())
                .username(professeur.getUsername())
                .password(professeur.getPassword())
                .grade(professeur.getGrade())
                .specialite(professeur.getSpecialite())
                .professeurClasseModules(professeur.getProfesseurClasseModules().stream().map(ProfesseurClasseModulesRelationResponseDto::toDto).toList())
                .cours(professeur.getCours().stream().map(CourRelationResponseDto::toDto).toList())
                .sessioncours(professeur.getSessioncours().stream().map(SessionRelationResponseDto::toDto).toList())
                .build();
    }


}
