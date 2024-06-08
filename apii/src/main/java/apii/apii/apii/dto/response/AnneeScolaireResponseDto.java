package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Emargement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnneeScolaireResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;

    public static AnneeScolaireResponseDto toDto(AnneeScolaire annee){
        return AnneeScolaireResponseDto
                .builder()
                .id(annee.getId())
                .active(annee.getActive())
                .libelle(annee.getLibelle())

                .build();
    }

}
