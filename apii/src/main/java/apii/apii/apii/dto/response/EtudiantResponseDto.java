package apii.apii.apii.dto.response;

import coree.coree.coree.Data.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantResponseDto {
    private Long id;
    private Boolean active;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private List<AppRoleResponseDto> roles;
    private String matricule;
    private String tuteur;
    private List<InscriptionRelationResponseDto> inscriptions;
    private List<AbscenceRelationResponseDto> absences;
    private List<EmargementRelationResponseDto> emargements;

    public static EtudiantResponseDto toDto(Etudiant etudiant){
        return EtudiantResponseDto
                .builder()
                .id(etudiant.getId())
                .active(etudiant.getActive())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .username(etudiant.getUsername())
                .password(etudiant.getPassword())
                .roles(etudiant.getRoles().stream().map(AppRoleResponseDto::toDto).toList())
                .matricule(etudiant.getMatricule())
                .tuteur(etudiant.getTuteur())
                .inscriptions(etudiant.getInscriptions().stream().map(InscriptionRelationResponseDto::toDto).toList())
                .absences(etudiant.getAbsences().stream().map(AbscenceRelationResponseDto::toDto).toList())
                .emargements(etudiant.getEmargements().stream().map(EmargementRelationResponseDto::toDto).toList())
                .build();
    }
}
