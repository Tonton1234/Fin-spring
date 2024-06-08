package apii.apii.apii.dto.request;

import coree.coree.coree.Data.entities.AnneeScolaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnneeScolaireRequestDto {
    private Long id;
    @NotBlank(message = "Le Libelle est obligatoire")
    private String libelle;

    public AnneeScolaire toEntity(){
        AnneeScolaire anneeScolaire= AnneeScolaire
                .builder()
                .libelle(libelle)
                .build();
        anneeScolaire.setActive(true);
        return anneeScolaire;
    }

}
