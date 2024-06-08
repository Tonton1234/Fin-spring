package apii.apii.apii.dto.request;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.Data.entities.Semestre;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreRequestDto {

    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;
    @NotBlank(message = "La niveau est obligatoire")
    private Niveau niveau;



    public Semestre toEntity(){
        return Semestre.builder()
                .libelle(libelle)
                .niveau(niveau)
                .build();
    }
}
