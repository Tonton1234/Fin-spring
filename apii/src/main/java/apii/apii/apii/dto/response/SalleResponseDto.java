package apii.apii.apii.dto.response;


import coree.coree.coree.Data.entities.SallesDeCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalleResponseDto {
    private Long id;
    private Boolean active;
    private String nom;
    private String numero;
    private int  nbrePlaces;
    public static SalleResponseDto toDto(SallesDeCours salle){
        return SalleResponseDto
                .builder()
                .id(salle.getId())
                .active(salle.getActive())
                .nom(salle.getNom())
                .numero(salle.getNumero())
                .nbrePlaces(salle.getNbrePlaces())
                .build();
    }
}
