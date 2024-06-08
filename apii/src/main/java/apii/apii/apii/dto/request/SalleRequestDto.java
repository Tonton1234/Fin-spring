package apii.apii.apii.dto.request;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.SallesDeCours;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalleRequestDto {
    private int nbrePlaces;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "La numero est obligatoire")
    private String numero;


    public SallesDeCours toEntity(){
        return SallesDeCours.builder()
                .nbrePlaces(nbrePlaces)
                .nom(nom)
                .numero(numero)
                .build();
    }
}
