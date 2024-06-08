package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.Emargement;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmargementResponseDto {
    private Long id;
    private LocalDate date;
    private boolean present;
    private EtudiantRelationResponseDto etudiant;
    private SessionRelationResponseDto sessionCours;

    public static EmargementResponseDto toDto(Emargement emargement){
        return EmargementResponseDto
                .builder()
                .id(emargement.getId())
                .date(emargement.getDate())
                .present(emargement.getPresent())
                .etudiant(EtudiantRelationResponseDto.toDto(emargement.getEtudiant()))
                .sessionCours(SessionRelationResponseDto.toDto(emargement.getSessionCours()) )
                .build();
    }

}
