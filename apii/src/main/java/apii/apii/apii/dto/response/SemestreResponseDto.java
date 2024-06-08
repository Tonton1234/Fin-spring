package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Semestre;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
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
public class SemestreResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;
    private Niveau niveau;
    private List<CourRelationResponseDto> cours ;
    public static SemestreResponseDto toDto(Semestre semestre){
        return SemestreResponseDto
                .builder()
                .id(semestre.getId())
                .active(semestre.getActive())
                .libelle(semestre.getLibelle())
                .niveau(semestre.getNiveau())
                .cours(semestre.getCours().stream().map(CourRelationResponseDto::toDto).toList())
                .build();
    }
}
