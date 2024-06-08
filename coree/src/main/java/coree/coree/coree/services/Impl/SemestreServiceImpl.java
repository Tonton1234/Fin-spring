package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.repositories.SemestreRepository;
import coree.coree.coree.services.SemestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;
    @Override
    public void save(Semestre data) {
        semestreRepository.save(data);
    }

    @Override
    public List<Semestre> getAll() {
        return semestreRepository.findAll();
    }

    @Override
    public Optional<Semestre> show(Long dataID) {
        return semestreRepository.findById(dataID);
    }

    @Override
    public Page<Semestre> findSemestreByActiveTrue(Pageable pageable) {
        return semestreRepository.findSemestreByActiveTrue(pageable);
    }
}
