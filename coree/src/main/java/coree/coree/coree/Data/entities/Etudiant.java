package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etudiant")
@DiscriminatorValue(value = "Etudiant")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Etudiant extends AppUser{
    @Column()
    private String matricule;
    @Column()
    private String tuteur;

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule='" + matricule + '\'' +
                ", tuteur='" + tuteur + '\'' +
                '}';
    }

    //Attributs navigationnels
    //mappedBy se met dans la classe qui  ne reçoit pas de clé étrangère
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Inscription> inscriptions;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Abscence> absences;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Emargement> emargements;
}
