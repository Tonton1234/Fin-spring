package coree.coree.coree.Data.entities;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "classe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Classe extends AbstractEntity{


    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Filiere filiere;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Niveau niveau;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return Objects.equals(libelle, classe.libelle) && filiere == classe.filiere && niveau == classe.niveau;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle, filiere, niveau);
    }

    @Column(nullable = false)
    private int place;
    @OneToMany(mappedBy = "classe",fetch = FetchType.EAGER)
    private List<ProfesseurClasseModules> professeurClasseModules;
    //Attributs navigationnels
    @ManyToMany(mappedBy = "classes")
    private List<Cours> cours;
    @OneToMany(mappedBy = "classe",fetch = FetchType.EAGER)
    private List<Inscription> inscriptions;
    public Classe(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "libelle='" + libelle + '\'' +
                ", filiere=" + filiere +
                ", niveau=" + niveau +
                '}';
    }
}
