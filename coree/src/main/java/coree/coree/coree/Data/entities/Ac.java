package coree.coree.coree.Data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ac")
@DiscriminatorValue(value = "AC")
@Data
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Ac extends AppUser{
    public Ac(String nom, String prenom, String username, String password, List<AppRole> roles) {
        super(nom, prenom, username, password, roles);
    }
}
