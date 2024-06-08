package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "emargements")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Emargement extends AbstractEntity{

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(nullable = true)
    private boolean present;

    //Attributs navigationnels;
    @ManyToOne
    @JoinColumn(name = "etudiant_id",nullable = true)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "session_cours_id",nullable = true)
    private SessionCours sessionCours;

    public boolean getPresent(){
        return present;
    }


    @Override
    public String toString() {
        return "Emargement{" +
                "date=" + date +
                ", present=" + present +
                ", id=" + id +
                '}';
    }
}

