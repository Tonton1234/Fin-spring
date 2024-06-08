package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleRelationResponseDto {
    private Long id;
    private Boolean active;
    private String libelle;

    public static ModuleRelationResponseDto toDto(Module module){
        return  ModuleRelationResponseDto
                .builder()
                .id(module.getId())
                .active(module.getActive())
                .libelle(module.getLibelle())
                .build();
    }
}
