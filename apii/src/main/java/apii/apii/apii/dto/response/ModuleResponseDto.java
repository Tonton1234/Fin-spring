package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;
    private List<CourRelationResponseDto> cours;
    private List<SessionRelationResponseDto> sessionCours;
    private List<ProfesseurClasseModulesRelationResponseDto> professeurClasseModules;
    public static ModuleResponseDto toDto(Module module){
        return  ModuleResponseDto
                .builder()
                .id(module.getId())
                .active(module.getActive())
                .libelle(module.getLibelle())
                .cours(module.getCours().stream().map(CourRelationResponseDto::toDto).toList())
                .sessionCours(module.getSessioncours().stream().map(SessionRelationResponseDto::toDto).toList())
                .professeurClasseModules(module.getProfesseurClasseModules().stream().map(ProfesseurClasseModulesRelationResponseDto::toDto).toList())
                .build();
    }
}
