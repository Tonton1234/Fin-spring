package coree.coree.coree.Data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Medecin extends AppUser {
    @Column()
    private String matricule;
    @Column()
    private String tuteur;
}
