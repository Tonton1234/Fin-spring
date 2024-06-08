package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Abscence extends AbstractEntity{
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column
    private  Boolean presence;

    @ManyToOne
    Etudiant etudiant;
    @ManyToOne
    SessionCours sessionCours;

    @OneToOne(mappedBy = "absence")
    Justification justification;

    @Override
    public String toString() {
        return "Absence{" +
                "date=" + date +
                ", id=" + id +
                '}';
    }
}
