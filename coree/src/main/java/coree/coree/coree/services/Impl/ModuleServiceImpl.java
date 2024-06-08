package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.ModuleRepository;
import coree.coree.coree.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    @Override
    public void save(Module data) {
        moduleRepository.save(data);
    }

    @Override
    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Optional<Module> show(Long dataID) {
        return moduleRepository.findById(dataID);
    }

    @Override
    public List<Module> findAllByActive() {
        return moduleRepository.findAllByActiveTrue();
    }

    @Override
    public Module findByLibelle(String libelle) {
        return moduleRepository.findModuleByLibelle(libelle);
    }

    @Override
    public Page<Module> findModuleByActiveTrue(Pageable pageable) {
        return moduleRepository.findModuleByActiveTrue(pageable);
    }
}
