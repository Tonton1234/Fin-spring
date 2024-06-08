package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Emargement;
import coree.coree.coree.Data.repositories.EmargementRepository;
import coree.coree.coree.services.EmmargementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmmargementServiceImpl implements EmmargementService {
    private final EmargementRepository emargementRepository;
    @Override
    public void save(Emargement data) {
        emargementRepository.save(data);
    }

    @Override
    public List<Emargement> getAll() {
        return emargementRepository.findAll();
    }

    @Override
    public Optional<Emargement> show(Long dataID) {
        return emargementRepository.findById(dataID);
    }

    @Override
    public Page<Emargement> getAllEmmargementByActiveTrue(Pageable pageable) {
        return emargementRepository.findByActiveTrue(pageable );
    }

    @Override
    public Page<Emargement> getAllEmmargementByActiveTrueAndDate(LocalDate date,Pageable pageable) {

        return  emargementRepository.findAllByActiveTrueAndDate(date,pageable);
    }

    @Override
    public Emargement getById(int id) {
        return emargementRepository.findById(id) ;
    }
}
