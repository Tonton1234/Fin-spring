package apii.apii.apii.dto.response;


import coree.coree.coree.Data.entities.Abscence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbscenceRelationResponseDto {
    private Long id;
    private Boolean active;
    private LocalDate date;


    public static AbscenceRelationResponseDto toDto(Abscence abscence){
        return AbscenceRelationResponseDto
                .builder()
                .id(abscence.getId())
                .active(abscence.getActive())
                .date(abscence.getDate())
                .build();
    }
}
