package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.EtudiantRequestService;
import apii.apii.apii.dto.request.EtudiantRequestDto;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.Data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EtudiantRequestServiceImpl implements EtudiantRequestService {
    private final EtudiantsRepository etudiantsRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepository appRoleRepository;
    private final InscriptionRepository inscriptionRepository;

    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void add(EtudiantRequestDto dto) {

        Etudiant etudiant=dto.toEntity();
        etudiant.setActive(true);
        etudiant.setMatricule(genererMatricule());
        etudiant.setPassword(passwordEncoder.encode("passer"));
        etudiantsRepository.save(etudiant);
    }
    public String genererMatricule() {
        return "MAT" + UUID.randomUUID().toString().substring(0, 6);
    }


    @Override
    public void importStudentsFromExcelFile(MultipartFile file) {
        List<AppRole> role=new ArrayList<>();
        role.add(appRoleRepository.findAllById(1));
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Insérer l'étudiant dans la base de données
            for (Row row : sheet) {
                // Lire les cellules de chaque ligne
                String prenom = row.getCell(0).getStringCellValue();
                String nom = row.getCell(1).getStringCellValue();
                String matricule = row.getCell(2).getStringCellValue();
                String tuteur = row.getCell(3).getStringCellValue();
                String login = row.getCell(4).getStringCellValue();
                String classe=row.getCell(5).getStringCellValue();

                // Créer un objet de type étudiant à partir des données de la ligne
                Etudiant etudiant = new Etudiant();
                // Recherche du role dans la base de données
                //Donner des états aux attributs
                etudiant.setPrenom(prenom);
                etudiant.setNom(nom);
                etudiant.setMatricule(matricule);
                etudiant.setTuteur(tuteur);
                etudiant.setMontype("ETUDIANT");
                etudiant.setUsername(login);
                etudiant.setPassword(passwordEncoder.encode("passer"));
                // Ajout du rôle à l'étudiant créer à partir de chaque ligne du fichier excel
                etudiant.setRoles(role);
                etudiant.setActive(true);
                // Insérer l'étudiant dans la base de données
                etudiantsRepository.save(etudiant);
                Inscription inscription=new Inscription();
                inscription.setActive(true);
                inscription.setCreateAt(LocalDate.now());
                inscription.setClasse(classeRepository.findClasseByLibelle(classe));
                inscription.setEtudiant(etudiantsRepository.findByNom(nom));
                inscription.setAnneeScolaire(anneeScolaireRepository.findAnneeScolaireByActiveTrue());
                inscriptionRepository.save(inscription);

            }
            // Fermer le workbook et le flux de données
            workbook.close();
            //inputStream.close();

        } catch (IOException e) {
            // Gérer les exceptions liées au fichier Excel
            e.printStackTrace();
        }
    }
}
