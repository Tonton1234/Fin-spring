package coree.coree.coree.Data.entities;

import coree.coree.coree.Data.Enum.EtatJustification;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "justification")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Justification extends AbstractEntity{

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(nullable = true)
    private String motif;

    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private EtatJustification etat;

    @OneToOne
    @JoinColumn(name = "absence_id",nullable = true)
    private Abscence absence;

    @Override
    public String toString() {
        return "Justification{" +
                "date=" + date +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
