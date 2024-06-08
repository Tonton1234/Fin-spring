package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.ProfesseurClasseModulesServiceRest;
import apii.apii.apii.dto.request.ProfesseurClasseModuleRequestDto;
import apii.apii.apii.dto.request.ProfesseurRequestDto;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesseurClasseModuleServiceRestImpl implements ProfesseurClasseModulesServiceRest {
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final SemestreRepository semestreRepository;
    @Override
    public void add(ProfesseurClasseModuleRequestDto dto) {

        Professeur professeur=professeurRepository.findProfesseurById(dto.getProfesseurId());
        Classe classe=classeRepository.findClasseById(dto.getClasseId());
        Semestre semestre=semestreRepository.findSemestreById(dto.getSemestre());
        List<Module> modules=toModule(dto.getModules(),dto.getProfesseurId(),dto.getClasseId());
        ProfesseurClasseModules professeurClasseModules= new ProfesseurClasseModules();
        professeurClasseModules.setProfesseur(professeur);
        professeurClasseModules.setClasse(classe);
        professeurClasseModules.setModules(modules);
        professeurClasseModules.setSemestre(semestre);
        professeurClasseModules.setAnneeScolaire(anneeScolaireRepository.findAnneeScolaireByActiveTrue());
        professeurClasseModules.setActive(true);
        System.out.println(professeurClasseModules.getProfesseur());
        System.out.println(professeurClasseModules.getClasse());
        professeurClasseModulesRepository.save(professeurClasseModules);
    }
    public List<Module> toModule(List<Long> mod,Long professeurId,Long classeId){
        List<Module> module = new ArrayList<>();
                /*professeurClasseModulesRepository.findProfesseurClasseModulesByProfesseurAndClasse(professeurRepository.findProfesseurById(professeurId),classeRepository.findClasseById(classeId)).getModules();*/
        List<Etudiant> etudiants=new ArrayList<>();
        mod.forEach(element -> {
            module.add(moduleRepository.findModuleById(element));
        });
        return module;
    }

    @Override
    public Page<ProfesseurClasseModules> getAllByModule(Module module, Pageable pageable) {
        return professeurClasseModulesRepository.findProfesseurClasseModulesByModulesAndActiveTrue(module,pageable);
    }

    @Override
    public Page<ProfesseurClasseModules> getAllByProfesseur(Professeur professeur, Pageable pageable) {
        return professeurClasseModulesRepository.findProfesseurClasseModulesByProfesseurAndActiveTrue(professeur,pageable);
    }

    @Override
    public Page<ProfesseurClasseModules> getAllByModuleAndProf(Module module, Professeur professeur, Pageable pageable) {
        return professeurClasseModulesRepository.findProfesseurClasseModulesByModulesAndProfesseurAndActiveTrue(module,professeur,pageable);
    }
}
