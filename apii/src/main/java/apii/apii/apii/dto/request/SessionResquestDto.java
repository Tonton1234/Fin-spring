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
public class SessionResquestDto {
    private Long salle;
    private Long cours;
    private String date;
    private String heureDebut;
    private String heureFin;
}
