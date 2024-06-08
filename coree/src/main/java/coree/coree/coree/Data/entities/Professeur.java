package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professeur")
@DiscriminatorValue(value = "Professeur")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Professeur extends AppUser {

    @Column(nullable = true)
    private String grade;

    @Column(nullable = true)
    private String specialite;

    @OneToMany(mappedBy = "professeur")
    private List<ProfesseurClasseModules> professeurClasseModules;

    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

    //Constructeur
    public Professeur(Long id, String nom, String prenom) {
        super(id, nom, prenom);
    }


    @Override
    public String toString() {
        return "Professeur{" +
                "grade='" + grade + '\'' +
                ", specialite='" + specialite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
