package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseRelationResponseDto {
    private Long id;
    private int place;
    private Boolean active;
    private String libelle;
    private Filiere filiere;
    private Niveau niveau;

    public static ClasseRelationResponseDto toDto(Classe classe){

        return ClasseRelationResponseDto
                .builder()
                .id(classe.getId())
                .place(classe.getPlace())
                .active(classe.getActive())
                .libelle(classe.getLibelle())
                .filiere(classe.getFiliere())
                .niveau(classe.getNiveau())

                .build();
    }
}
