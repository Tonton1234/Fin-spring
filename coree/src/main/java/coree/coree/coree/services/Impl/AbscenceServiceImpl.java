package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Abscence;
import coree.coree.coree.Data.repositories.AbscenceRepository;
import coree.coree.coree.services.AbscenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AbscenceServiceImpl implements AbscenceService {
    private final AbscenceRepository abscenceRepository;
    @Override
    public void save(Abscence data) {
        abscenceRepository.save(data);
    }

    @Override
    public List<Abscence> getAll() {
        return null;
    }

    @Override
    public Optional<Abscence> show(Long dataID) {
        return Optional.empty();
    }
    @Override
    public Page<Abscence> getAllByActiveTrue(Pageable pageable) {
        return abscenceRepository.getAllByActiveTrue(pageable);
    }
}
