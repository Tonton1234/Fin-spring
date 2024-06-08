package coree.coree.coree.Data.entities;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.Enum.EtatSessionCours;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "session_cours")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder

public class SessionCours extends AbstractEntity{


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column
    private String libelle;

    @Column(columnDefinition = "TIME",nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime heureDebut;

    @Column(columnDefinition = "TIME",nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime heureFin;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatSessionCours etat;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatLieu Lieu;


    //Attributs navigationnels
    @ManyToOne
    @JoinColumn(name = "cours_id",nullable = true)
    Cours cours;

    @ManyToOne
    @JoinColumn(name = "salles_cours_id",nullable = true)
    SallesDeCours sallescours;

    @ManyToOne
    @JoinColumn(name = "professeur_id",nullable = true)
    Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "module_id",nullable = true)
    Module module;

    @OneToOne(mappedBy = "sessionCours")
    DemandeAnnulation demandeAnnulation;

    @OneToMany(mappedBy = "sessionCours",fetch = FetchType.LAZY)
    private List<Abscence> absences;

    @OneToMany(mappedBy = "sessionCours",fetch = FetchType.LAZY)
    private List<Emargement> emargements;

    @Override
    public String toString() {
        return "SessionCours{" +
                "date=" + date +
                ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin +
                ", etat=" + etat +
                ", Lieu=" + Lieu +
                ", id=" + id +
                '}';
    }
}

