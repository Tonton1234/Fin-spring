package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurClasseModulesResponseDto {
    private Long id;
    private Boolean active;
    private ProfesseurRelationResponseDto professeur;
    private ClasseRelationResponseDto classe;
    private List<ModuleRelationResponseDto> modules;
    private AnneeScolaireRelationResponseDto anneeScolaire;
    private SemestreRelationResponseDto semestre;
    public static ProfesseurClasseModulesResponseDto toDto(ProfesseurClasseModules professeurClasseModules){
        return ProfesseurClasseModulesResponseDto
                .builder()
                .id(professeurClasseModules.getId())
                .active(professeurClasseModules.getActive())
                .professeur(ProfesseurRelationResponseDto.toDto(professeurClasseModules.getProfesseur()) )
                .classe(ClasseRelationResponseDto.toDto(professeurClasseModules.getClasse()) )
                .modules(professeurClasseModules.getModules().stream().map(ModuleRelationResponseDto::toDto).toList())
                .anneeScolaire(AnneeScolaireRelationResponseDto.toDto(professeurClasseModules.getAnneeScolaire()) )
                .semestre(SemestreRelationResponseDto.toDto(professeurClasseModules.getSemestre()))
                .build();
    }
}
