package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "inscription")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder

public class Inscription extends AbstractEntity{
    @Column()
    private LocalDate createAt;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private AnneeScolaire anneeScolaire;

    @Override
    public String toString() {
        return "Inscription{" +
                "createAt=" + createAt +
                ", id=" + id +
                '}';
    }
}
