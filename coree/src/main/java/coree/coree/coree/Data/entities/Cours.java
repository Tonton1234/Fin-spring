package coree.coree.coree.Data.entities;

import coree.coree.coree.Data.Enum.EtatCours;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "cours")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Cours extends AbstractEntity{


    @Column(nullable = false)
    private int nbreHeureGlobal;
    @Column(nullable = false)
    private int nbreHeurePlanifier;
    @Column(nullable = false)
    private int nbreHeureRestant;
    @Column(nullable = true)
    private String libelle;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatCours etat;


    //Attributs navigationnels
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Semestre> semestres;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Classe> classes;

    @OneToMany(mappedBy = "cours")
    private List<SessionCours> sessioncours;

    @ManyToOne
    @JoinColumn(nullable = true)
    Module module;

    @ManyToOne
    @JoinColumn(nullable = true)
    Professeur professeur;

    @ManyToOne
    @JoinColumn(nullable = true)
    AnneeScolaire anneeScolaire;

    @ManyToOne
    @JoinColumn(nullable = true)
    Periode periode;

    @Override
    public String toString() {
        return "Cours{" +
                "nbreHeureGlobal=" + nbreHeureGlobal +
                ", etat=" + etat +
                ", id=" + id +
                '}';
    }


}
