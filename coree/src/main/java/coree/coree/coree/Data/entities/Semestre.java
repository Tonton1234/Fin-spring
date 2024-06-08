package coree.coree.coree.Data.entities;

import coree.coree.coree.Data.Enum.Niveau;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "semestre")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Semestre extends AbstractEntity{

    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private Niveau niveau;

    @ManyToMany(mappedBy = "semestres",fetch = FetchType.LAZY)
    private List<Cours> cours ;

    @Override
    public String toString() {
        return "Semestre{" +
                "libelle='" + libelle + '\'' +
                ", id=" + id +
                '}';
    }
}
