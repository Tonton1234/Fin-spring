package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professeurClasseModules")
@DiscriminatorValue(value = "Professeur")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class ProfesseurClasseModules extends AbstractEntity{
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private Classe classe;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Module> modules;
    @ManyToOne
    private AnneeScolaire anneeScolaire;
    @ManyToOne
    private Semestre semestre;

    @Override
    public String toString() {
        return "ProfesseurClasseModules{" +
                "id=" + id +
                '}';
    }
}
