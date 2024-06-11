package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.Enum.EtatCours;
import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.repositories.CoursRepository;
import coree.coree.coree.services.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    @Override
    public void save(Cours data) {
        coursRepository.save(data);
    }

    @Override
    public List<Cours> getAll() {
        return coursRepository.findAll();
    }

    @Override
    public Optional<Cours> show(Long dataID) {
        return coursRepository.findById(dataID);
    }

    @Override
    public Page<Cours> getAllCoursByActiveTrue(Pageable pageable) {
        return coursRepository.findCoursByActiveTrue(pageable);
    }

    @Override
    public Cours getById(Long ig) {
        return coursRepository.findCoursById(ig);
    }

    @Override
    public Page<Cours> getAllCoursByActiveTrueAndEncours(Pageable pageable) {
        return coursRepository.findCoursByEtatAndActiveTrue(EtatCours.Encours,pageable);
    }

    @Override
    public Page<Cours> getAllCoursByActiveTrueAndTerminer(Pageable pageable) {
        return  coursRepository.findCoursByEtatAndActiveTrue(EtatCours.Terminer,pageable);
    }

    @Override
    public Page<Cours> getAllCoursByActiveTrueAndProfesseur(Professeur prof, Pageable pageable) {
        return coursRepository.findCoursByProfesseurAndActiveTrue(prof,pageable);
    }


}
