package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue(value = "User")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AppUser extends AbstractEntity{

    @Column(nullable = false)
    protected String nom;
    @Column(nullable = true)
    protected String montype;
    @Column(nullable = false)
    protected String prenom;

    @Column(nullable = true,unique = true)
    protected String username;

    @Column(nullable = true)
    protected String password;

    public AppUser(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<AppRole> roles=new ArrayList<>();

    public AppUser(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public AppUser(Boolean active, String username, String password) {
        super(active);
        this.username = username;
        this.password = password;
    }
    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser appUser)) return false;
        return Objects.equals(getNom(), appUser.getNom()) && Objects.equals(getPrenom(), appUser.getPrenom()) && Objects.equals(getUsername(), appUser.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getUsername());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
