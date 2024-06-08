package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourResponseDto {

    private Long id;
    private String libelle;
    private Boolean active;
    private int nbreHeureGlobal;
    private int nbreHeurePlanifier;
    private int nbreHeureRestante;
    private EtatCours etat;
    private List<SemestreRelationResponseDto> semestres;
    private List<ClasseRelationResponseDto> classes;
    private List<SessionRelationResponseDto> sessionCours;
    private ModuleRelationResponseDto module;
    private ProfesseurRelationResponseDto professeur;
    private AnneeScolaireRelationResponseDto anneeScolaire;
    public static CourResponseDto toDto(Cours cours){
        return CourResponseDto
                .builder()
                .id(cours.getId())
                .nbreHeurePlanifier(cours.getNbreHeurePlanifier())
                .nbreHeureRestante(cours.getNbreHeureRestant())
                .libelle(cours.getLibelle())
                .nbreHeureGlobal(cours.getNbreHeureGlobal())
                .etat(cours.getEtat())
                .semestres(cours.getSemestres().stream().map(SemestreRelationResponseDto::toDto).toList())
                .classes(cours.getClasses().stream().map(ClasseRelationResponseDto::toDto).toList())
                .sessionCours(cours.getSessioncours().stream().map(SessionRelationResponseDto::toDto).toList())
                .module(ModuleRelationResponseDto.toDto(cours.getModule()))
                .professeur(ProfesseurRelationResponseDto.toDto(cours.getProfesseur()))
                .anneeScolaire(AnneeScolaireRelationResponseDto.toDto(cours.getAnneeScolaire()))
                .active(cours.getActive())
                .build();
    }
}
