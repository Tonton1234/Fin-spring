package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscriptionResponseDto {
    private Long id;
    private Boolean active;
    private LocalDate date;
    private EtudiantRelationResponseDto etudiant;
    private ClasseRelationResponseDto classe;
    private AnneeScolaireRelationResponseDto anneeScolaire;
    public static InscriptionResponseDto toDto (Inscription inscription){
        return InscriptionResponseDto
                .builder()
                .id(inscription.getId())
                .active(inscription.getActive())
                .date(inscription.getCreateAt())
                .etudiant(EtudiantRelationResponseDto.toDto(inscription.getEtudiant()) )
                .classe(ClasseRelationResponseDto.toDto(inscription.getClasse()) )
                .anneeScolaire(AnneeScolaireRelationResponseDto.toDto(inscription.getAnneeScolaire()) )
                .build();
    }
}
