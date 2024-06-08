package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatJustification;
import coree.coree.coree.Data.entities.Justification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JustificationRelationResponseDto {
    private Long id;
    private Boolean active;
    private Date date;
    private String motif;
    private EtatJustification etat;


    public static JustificationRelationResponseDto toDto (Justification justification){
        return JustificationRelationResponseDto
                .builder()
                .id(justification.getId())
                .active(justification.getActive())
                .date(justification.getDate())
                .motif(justification.getMotif())
                .etat(justification.getEtat())

                .build();
    }
}
