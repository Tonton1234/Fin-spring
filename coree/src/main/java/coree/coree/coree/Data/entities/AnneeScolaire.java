package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "annee_scolaire")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class AnneeScolaire extends AbstractEntity{

    @Column(nullable = false)
    private String libelle;
    @OneToMany(mappedBy = "anneeScolaire")
    private List<Cours> cours;

    @Override
    public String toString() {
        return "AnneeScolaire{" +
                "libelle='" + libelle + '\'' +
                ", id=" + id +
                '}';
    }
}
