package apii.apii.apii.dto.request;

import coree.coree.coree.Data.entities.Professeur;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class ProfesseurRequestDto {

    private final PasswordEncoder passwordEncoder;

    @NotBlank(message = "Le nom  est obligatoire")
    private String nom;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "Le username  est obligatoire")
    private String username;
    @NotBlank(message = "Le grade  est obligatoire")
    private String grade;
    @NotBlank(message = "Le specialite est obligatoire")
    private String specialite;

    public  Professeur toEntity(){
        Professeur professeur=Professeur.builder()
                .grade(grade)
                .specialite(specialite)
                .build();
        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setUsername(username);

        return  professeur;

    }


}
