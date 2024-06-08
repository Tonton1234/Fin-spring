package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.*;
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
public class SessionResponseDto {
    private Long id;
    private LocalDate date;
    private String libelle;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private EtatSessionCours etat;
    private boolean active;
    private EtatLieu lieu;
    private CourRelationResponseDto cours;

    private ProfesseurRelationResponseDto professeur;
    private ModuleRelationResponseDto module;
    public static SessionResponseDto toDto(SessionCours sessionCours){
        return SessionResponseDto
                .builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .libelle(sessionCours.getLibelle())
                .heureDebut(sessionCours.getHeureDebut())
                .heureFin(sessionCours.getHeureFin())
                .etat(sessionCours.getEtat())
                .active(sessionCours.getActive())
                .lieu(sessionCours.getLieu())
                .cours(CourRelationResponseDto.toDto(sessionCours.getCours()) )

                .professeur(ProfesseurRelationResponseDto.toDto(sessionCours.getProfesseur()) )
                .module(ModuleRelationResponseDto.toDto(sessionCours.getModule()) )
                .build();
    }
}
