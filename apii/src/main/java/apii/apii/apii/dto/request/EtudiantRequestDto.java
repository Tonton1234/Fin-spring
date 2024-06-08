package apii.apii.apii.dto.request;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Professeur;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class EtudiantRequestDto {

    private final PasswordEncoder passwordEncoder;

    @NotBlank(message = "Le nom  est obligatoire")
    private String nom;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "Le username  est obligatoire")
    private String username;
    @NotBlank(message = "Le password est obligatoire")
    private String password;
    @NotBlank(message = "Le tuteur  est obligatoire")
    private String tuteur;
    @NotBlank(message = "Le matricule est obligatoire")
    private String matricule;

    public  Etudiant toEntity(){
        Etudiant etudiant=Etudiant.builder()
                .tuteur(tuteur)
                .matricule(matricule)
                .build();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setUsername(username);
        assert passwordEncoder != null;
        etudiant.setPassword(passwordEncoder.encode(password) );
        return  etudiant;

    }


}
