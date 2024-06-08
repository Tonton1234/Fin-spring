package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.CoursServiceRest;
import apii.apii.apii.dto.request.CoursRequestDto;
import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursServiceRestImpl implements CoursServiceRest {
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final SemestreRepository semestreRepository;
    private final CoursRepository coursRepository;

    @Override
    public void add(CoursRequestDto dto) {
        Professeur professeur=professeurRepository.findProfesseurById(dto.getProfesseur());
        List<Classe> classes=toClasses(dto.getClasses());
        Module module=moduleRepository.findModuleById(dto.getModule());
        Semestre semestre=semestreRepository.findSemestreById(dto.getSemestre());
        List<Semestre> sem=new ArrayList<>();
        sem.add(semestre);
        String libelle=module.getLibelle() +" "+professeur.getNom();
        Cours cours=new Cours();
        cours.setEtat(EtatCours.Encours);
        cours.setProfesseur(professeur);
        cours.setSemestres(sem);
        cours.setAnneeScolaire(anneeScolaireRepository.findAnneeScolaireByActiveTrue());
        cours.setActive(true);
        cours.setNbreHeureGlobal(dto.getNbreHeureGlobal());
        cours.setNbreHeurePlanifier(0);
        cours.setNbreHeureRestant(dto.getNbreHeureGlobal());
        cours.setLibelle(libelle);
        cours.setClasses(classes);
        cours.setModule(module);
        coursRepository.save(cours);
    }
    public List<Classe> toClasses(List<Long> classes){
        List<Classe> classe = new ArrayList<>();
        classes.forEach(element -> {
            classe.add(classeRepository.findClasseById(element));
        });
        return classe;
    }

}
