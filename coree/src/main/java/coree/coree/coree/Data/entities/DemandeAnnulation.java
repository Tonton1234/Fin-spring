package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "demande_annulation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class DemandeAnnulation extends AbstractEntity{


    @Column(nullable = true)
    private String motif;
    //Attributs navigationnels
    @OneToOne
    @JoinColumn(name = "session_cours_id",nullable = true)
    private SessionCours sessionCours;

    @Override
    public String toString() {
        return "DemandeAnnulation{" +
                "motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
