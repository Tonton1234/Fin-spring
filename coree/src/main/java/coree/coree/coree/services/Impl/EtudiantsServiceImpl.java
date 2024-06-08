package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.repositories.EtudiantsRepository;
import coree.coree.coree.services.EtudiantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantsServiceImpl implements EtudiantsService {
    private final EtudiantsRepository etudiantsRepository;

    @Override
    public void save(Etudiant data) {
        etudiantsRepository.save(data);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantsRepository.findAll();
    }

    @Override
    public Optional<Etudiant> show(Long dataID) {
        return etudiantsRepository.findById(dataID);
    }

    @Override
    public Page<Etudiant> findEdutiantByActiveTrue(Pageable pageable) {
        return etudiantsRepository.findEtudiantByActiveTrue(pageable);
    }
}
