package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.repositories.AnneeScolaireRepository;
import coree.coree.coree.services.AnneeScolaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnneeScolaireServiceImpl implements AnneeScolaireService {
    private final AnneeScolaireRepository anneeScolaireRepository;
    @Override
    public void save(AnneeScolaire data) {
        anneeScolaireRepository.save(data);
    }

    @Override
    public List<AnneeScolaire> getAll() {
        return anneeScolaireRepository.findAll();
    }

    @Override
    public Optional<AnneeScolaire> show(Long dataID) {
        return anneeScolaireRepository.findById(dataID);
    }

    @Override
    public Page<AnneeScolaire> getAllAnneeScolaireByActiveTrue(Pageable pageable) {
        return anneeScolaireRepository.findByActiveTrue(pageable);
    }

    @Override
    public Page<AnneeScolaire> getAllAnneeScolaire(Pageable pageable) {
        return  anneeScolaireRepository.findAll(pageable);
    }
}
