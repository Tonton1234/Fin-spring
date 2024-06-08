package apii.apii.apii.dto.request;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.repositories.ClasseRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseRequestDto {

    private int place;
    @NotBlank(message = "Le Libelle est obligatoire")
    private String libelle;
    @NotBlank(message = "La filiere est obligatoire")
    private String filiere;
    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    public Classe toEntity(){
        return Classe.builder()
                .place(place)
                .libelle(libelle)
                .filiere(Filiere.toEnum(Integer.parseInt(filiere)))
                .niveau(Niveau.toEnum(Integer.parseInt(niveau)))
                .build();
    }
}
