package coree.coree.coree.Data.entities;

import jakarta.persistence.Column;
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


    @Override
    public String toString() {
        return "Ac{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Ac(String nom,String mt ,String prenom, String username, String password, List<AppRole> roles) {
        super(nom,mt, prenom, username, password, roles);
    }
}
