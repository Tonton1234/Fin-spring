package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.AnneeScolaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnneeScolaireRelationResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;

    public static AnneeScolaireRelationResponseDto toDto(AnneeScolaire annee){
        return AnneeScolaireRelationResponseDto
                .builder()
                .id(annee.getId())
                .active(annee.getActive())
                .libelle(annee.getLibelle())

                .build();
    }

}
