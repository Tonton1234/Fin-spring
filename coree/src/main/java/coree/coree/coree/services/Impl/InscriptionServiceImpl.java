package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Etudiant;
import coree.coree.coree.Data.entities.Inscription;
import coree.coree.coree.Data.repositories.InscriptionRepository;
import coree.coree.coree.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    @Override
    public Page<Inscription> findInscriptionByActiveTrue(Pageable pageable) {
        return inscriptionRepository.findInscriptionByActiveTrue(pageable);
    }

    @Override
    public void save(Inscription data) {
        inscriptionRepository.save(data);
    }

    @Override
    public List<Inscription> getAll() {
        return null;
    }

    @Override
    public Optional<Inscription> show(Long dataID) {
        return Optional.empty();
    }
}
