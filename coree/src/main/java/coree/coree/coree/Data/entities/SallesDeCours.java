package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "salles_cours")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class SallesDeCours extends AbstractEntity{

    @Column()
    private String nom;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private int  nbrePlaces;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SallesDeCours that = (SallesDeCours) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    //Attributs navigationnels
    @OneToMany(mappedBy = "sallescours",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

    @Override
    public String toString() {
        return "SallesDeCours{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
