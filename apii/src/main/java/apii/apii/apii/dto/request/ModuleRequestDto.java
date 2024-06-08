package apii.apii.apii.dto.request;

import coree.coree.coree.Data.Enum.Niveau;
import coree.coree.coree.Data.entities.Module;
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
public class ModuleRequestDto {

    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;

    public Module toEntity(){
        return Module.builder()
                .libelle(libelle)
                .build();
    }
}
