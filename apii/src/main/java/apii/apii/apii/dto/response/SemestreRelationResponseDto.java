package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreRelationResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;
    private Niveau niveau;

    public static SemestreRelationResponseDto toDto(Semestre semestre){
        return SemestreRelationResponseDto
                .builder()
                .id(semestre.getId())
                .active(semestre.getActive())
                .libelle(semestre.getLibelle())
                .niveau(semestre.getNiveau())
                .build();
    }
}
