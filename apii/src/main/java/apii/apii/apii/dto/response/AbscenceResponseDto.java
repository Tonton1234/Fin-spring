package apii.apii.apii.dto.response;


import coree.coree.coree.Data.entities.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbscenceResponseDto {
    private Long id;
    private Boolean abscence;
    private Boolean active;
    private LocalDate date;
    private EtudiantRelationResponseDto etudiant;
    private SessionRelationResponseDto sessionCours;
    private JustificationRelationResponseDto justification;


    public static AbscenceResponseDto toDto(Abscence abscence){
        return AbscenceResponseDto
                .builder()
                .id(abscence.getId())
                .abscence(abscence.getPresence())
                .active(abscence.getActive())
                .date(abscence.getDate())
                .etudiant(EtudiantRelationResponseDto.toDto(abscence.getEtudiant()))
                .sessionCours(SessionRelationResponseDto.toDto(abscence.getSessionCours()))
                .justification(JustificationRelationResponseDto.toDto(abscence.getJustification()))
                .build();
    }
}
