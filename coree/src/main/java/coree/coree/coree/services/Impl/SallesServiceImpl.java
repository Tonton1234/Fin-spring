package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.Data.repositories.SallesCoursRepository;
import coree.coree.coree.services.SallesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SallesServiceImpl implements SallesService {
    private final SallesCoursRepository sallesCoursRepository;
    @Override
    public void save(SallesDeCours data) {
        sallesCoursRepository.save(data);
    }

    @Override
    public List<SallesDeCours> getAll() {
        return sallesCoursRepository.findAll();
    }

    @Override
    public Optional<SallesDeCours> show(Long dataID) {
        return sallesCoursRepository.findById(dataID);
    }

    @Override
    public Page<SallesDeCours> findSalleByActiveTrue(Pageable pageable) {
        return sallesCoursRepository.findSallesDeCoursByActiveTrue(pageable);
    }
}
