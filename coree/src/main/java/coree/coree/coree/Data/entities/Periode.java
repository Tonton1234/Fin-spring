package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "periode")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Periode extends AbstractEntity{


    @Column(nullable = true)
    private String libelle;
    //Attributs navigationnels
    @OneToMany(mappedBy = "periode",fetch = FetchType.LAZY)
    private List<Cours> cours;

}
