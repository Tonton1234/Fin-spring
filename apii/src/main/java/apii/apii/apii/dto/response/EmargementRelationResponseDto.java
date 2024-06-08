package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Emargement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmargementRelationResponseDto {
    private Long id;
    private LocalDate date;
    private boolean present;


    public static EmargementRelationResponseDto toDto(Emargement emargement){
        return EmargementRelationResponseDto
                .builder()
                .id(emargement.getId())
                .date(emargement.getDate())
                .present(emargement.getPresent())
                .build();
    }

}
