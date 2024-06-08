package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurClasseModulesRelationResponseDto {
    private Long id;
    private Boolean active;

    public static ProfesseurClasseModulesRelationResponseDto toDto(ProfesseurClasseModules professeurClasseModules){
        return ProfesseurClasseModulesRelationResponseDto
                .builder()
                .id(professeurClasseModules.getId())
                .active(professeurClasseModules.getActive())

                .build();
    }
}
