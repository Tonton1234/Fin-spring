package springg.springg.springg.dto.Response;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    private Cours cours;
    private SallesDeCours sallescours;
    private Professeur professeur;
    private Module module;
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
                .cours(sessionCours.getCours())
                .sallescours(sessionCours.getSallescours())
                .professeur(sessionCours.getProfesseur())
                .module(sessionCours.getModule())
                .build();
    }
}
