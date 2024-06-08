package coree.coree.coree.Data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "rp")
@DiscriminatorValue(value = "RP")
@AllArgsConstructor
@Setter
@Getter

@Data
public class RP extends AppUser {
}
