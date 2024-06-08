package coree.coree.coree.Data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "module")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Module extends AbstractEntity{

    @Column(nullable = false)
    private String libelle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(libelle, module.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }

    //Attributs navigationnels
    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;
    @ManyToMany(mappedBy = "modules")
    private List<ProfesseurClasseModules> professeurClasseModules;

    @Override
    public String toString() {
        return "Module{" +
                "libelle='" + libelle + '\'' +
                ", id=" + id +
                ", active=" + active +
                '}';
    }
}
