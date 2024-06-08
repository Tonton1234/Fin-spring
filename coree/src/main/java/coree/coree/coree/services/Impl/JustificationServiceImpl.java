package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Justification;
import coree.coree.coree.Data.repositories.JustificationRepository;
import coree.coree.coree.services.JustificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JustificationServiceImpl implements JustificationService {
    private final JustificationRepository justificationRepository;
    @Override
    public void save(Justification data) {
        justificationRepository.save(data);
    }

    @Override
    public List<Justification> getAll() {
        return justificationRepository.findAll();
    }

    @Override
    public Optional<Justification> show(Long dataID) {
        return justificationRepository.findById(dataID);
    }

    @Override
    public Page<Justification> findJustificationByActiveTrue(Pageable pageable) {
        return justificationRepository.findJustificationByActiveTrue(pageable);
    }
}
