package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.ProfesseurClasseModules;
import coree.coree.coree.Data.repositories.ProfesseurClasseModulesRepository;
import coree.coree.coree.services.ProfesseurClasseModulesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProfesseurClasseModulesServicesImpl implements ProfesseurClasseModulesServices {
    private final ProfesseurClasseModulesRepository professeurClasseModulesRepository;
    @Override
    public Page<ProfesseurClasseModules> findProfesseurClasseModulesByActiveTrue(Pageable pageable) {
        return professeurClasseModulesRepository.findProfesseurClasseModulesByActiveTrue(pageable);
    }

    @Override
    public void save(ProfesseurClasseModules data) {
        professeurClasseModulesRepository.save(data);
    }

    @Override
    public List<ProfesseurClasseModules> getAll() {
        return null;
    }

    @Override
    public Optional<ProfesseurClasseModules> show(Long dataID) {
        return Optional.empty();
    }
}
