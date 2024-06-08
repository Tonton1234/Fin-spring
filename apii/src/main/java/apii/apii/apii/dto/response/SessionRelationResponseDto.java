package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionRelationResponseDto {
    private Long id;
    private LocalDate date;
    private String libelle;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private EtatSessionCours etat;
    private boolean active;
    private EtatLieu lieu;
    public static SessionRelationResponseDto toDto(SessionCours sessionCours){
        return SessionRelationResponseDto
                .builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .libelle(sessionCours.getLibelle())
                .heureDebut(sessionCours.getHeureDebut())
                .heureFin(sessionCours.getHeureFin())
                .etat(sessionCours.getEtat())
                .active(sessionCours.getActive())
                .lieu(sessionCours.getLieu())
                .build();
    }
}
