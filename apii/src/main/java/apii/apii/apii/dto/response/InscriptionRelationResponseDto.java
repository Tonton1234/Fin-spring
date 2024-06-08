package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Inscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscriptionRelationResponseDto {
    private Long id;
    private Boolean active;
    private LocalDate date;

    public static InscriptionRelationResponseDto toDto (Inscription inscription){
        return InscriptionRelationResponseDto
                .builder()
                .id(inscription.getId())
                .active(inscription.getActive())
                .date(inscription.getCreateAt())

                .build();
    }
}
