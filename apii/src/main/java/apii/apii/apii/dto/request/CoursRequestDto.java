package apii.apii.apii.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursRequestDto {
    private Long professeur;
    private List<Long> classes;
    private Long module;
    private int nbreHeureGlobal;
    private Long semestre;
}
