package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.repositories.ClasseRepository;
import coree.coree.coree.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {
    private  final ClasseRepository classeRepository;
    @Override
    public void save(Classe data) {
        classeRepository.save(data);
    }

    @Override
    public List<Classe> getAll() {
        return classeRepository.findAll();
    }

    @Override
    public Optional<Classe> show(Long dataID) {
        return classeRepository.findById(dataID);
    }

    @Override
    public Page<Classe> getAllClassesByActiveTrue(Pageable pageable) {
        return classeRepository.findClasseByActiveTrue(pageable);
    }

    @Override
    public Page<Classe> getAllClassesByLibelleAndActiveTrue(String libelle, Pageable pageable) {
        return classeRepository.findClasseByLibelleContainsAndActiveTrue(libelle,pageable);
    }

    @Override
    public Classe getById(Long id) {
        return classeRepository.findClasseById(id);
    }
}
