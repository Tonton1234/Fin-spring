package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.DemandeAnnulation;
import coree.coree.coree.Data.repositories.DemandeAnnulationRepository;
import coree.coree.coree.services.DemandeAnnulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeAnnulationServiceImpl implements DemandeAnnulationService{
    private final DemandeAnnulationRepository demandeAnnulationRepository;

    @Override
    public void save(DemandeAnnulation data) {
        demandeAnnulationRepository.save(data);
    }

    @Override
    public List<DemandeAnnulation> getAll() {
        return demandeAnnulationRepository.findAll();
    }

    @Override
    public Optional<DemandeAnnulation> show(Long dataID) {
        return demandeAnnulationRepository.findById(dataID);
    }
}
