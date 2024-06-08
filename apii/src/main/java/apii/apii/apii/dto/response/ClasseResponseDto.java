package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Inscription;
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
public class ClasseResponseDto {
    private Long id;
    private int place;
    private Boolean active;
    private String libelle;
    private Filiere filiere;
    private Niveau niveau;
   /* private List<InscriptionRelationResponseDto>  inscriptionResponseDto;
    private List<ProfesseurClasseModulesRelationResponseDto> professeurClasseModulesRelationResponseDtos;
    private List<CourRelationResponseDto> cours;*/
    public static ClasseResponseDto toDto(Classe classe){

        return ClasseResponseDto
                .builder()
                .id(classe.getId())
                .place(classe.getPlace())
                .active(classe.getActive())
                .libelle(classe.getLibelle())
                .filiere(classe.getFiliere())
                .niveau(classe.getNiveau())
               /* .inscriptionResponseDto(classe.getInscriptions().stream().map(InscriptionRelationResponseDto::toDto).toList())
                .professeurClasseModulesRelationResponseDtos(classe.getProfesseurClasseModules().stream().map(ProfesseurClasseModulesRelationResponseDto::toDto).toList())
                .cours(classe.getCours().stream().map(CourRelationResponseDto::toDto).toList())*/
                .build();
    }
}
