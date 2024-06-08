package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.repositories.ProfesseurRepository;
import coree.coree.coree.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private final ProfesseurRepository professeurRepository;
    @Override
    public void save(Professeur data) {
        professeurRepository.save(data);
    }

    @Override
    public List<Professeur> getAll() {
        return professeurRepository.findAll();
    }

    @Override
    public Optional<Professeur> show(Long dataID) {
        return professeurRepository.findById(dataID);
    }

    @Override
    public Professeur findByNom(String nom) {
        return professeurRepository.findByNom(nom);
    }

    @Override
    public Page<Professeur> findProfesseurByActiveTrue(Pageable pageable) {
        return professeurRepository.findProfesseurByActiveTrue(pageable);
    }
}
