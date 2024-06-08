package apii.apii.apii.dto.request;

import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.Data.repositories.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurClasseModuleRequestDto {

    private Long professeurId;
    private Long classeId;
    private List<Long> modules;
    private Long semestre;



}
