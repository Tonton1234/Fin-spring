package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.Cours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourRelationResponseDto {

    private Long id;
    private String libelle;
    private Boolean active;
    private int nbreHeureGlobal;
    private EtatCours etat;
    private int nbreHeurePlanifier;
    private int nbreHeureRestante;

    public static CourRelationResponseDto toDto(Cours cours){
        return CourRelationResponseDto
                .builder()
                .id(cours.getId())
                .nbreHeurePlanifier(cours.getNbreHeurePlanifier())
                .nbreHeureRestante(cours.getNbreHeureRestant())
                .libelle(cours.getLibelle())
                .nbreHeureGlobal(cours.getNbreHeureGlobal())
                .etat(cours.getEtat())
                .active(cours.getActive())
                .build();
    }
}
