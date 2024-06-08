package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.SessionCours;
import coree.coree.coree.Data.repositories.SessionCoursRepository;
import coree.coree.coree.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionCoursRepository;
    @Override
    public void save(SessionCours data) {
        sessionCoursRepository.save(data);
    }

    @Override
    public List<SessionCours> getAll() {
        return sessionCoursRepository.findAll();
    }

    @Override
    public Optional<SessionCours> show(Long dataID) {
        return sessionCoursRepository.findById(dataID);
    }

    @Override
    public Page<SessionCours> getAllByActiveTrue(Pageable pageable) {
        return sessionCoursRepository.findByActiveTrue(pageable);
    }

    @Override
    public Page<SessionCours> getAllByDate(LocalDate date, Pageable pageable) {
        return sessionCoursRepository.findAllByActiveTrueAndDate(date,pageable);
    }

    @Override
    public List<SessionCours> getAllByDate(LocalDate date) {
        return sessionCoursRepository.findAllByActiveTrueAndDate(date);
    }

    @Override
    public Page<SessionCours> getAllByModule(Module module, Pageable pageable) {
        return sessionCoursRepository.findAllByActiveTrueAndModule(module,pageable);
    }

    @Override
    public Page<SessionCours> getAllByCoursId(Long id, Pageable pageable) {
        return sessionCoursRepository.findByCoursIdAndAndActiveTrue(id,pageable);
    }

    @Override
    public List<SessionCours> getAllByModule(Module module) {
        return sessionCoursRepository.findAllByActiveTrueAndModule(module);
    }

    @Override
    public Page<SessionCours> getAllByProfesseur(Professeur prof, Pageable pageable) {
        return sessionCoursRepository.findAllByProfesseur(prof,pageable);
    }

    @Override
    public List<SessionCours> getAllByProfesseur(AppUser prof) {
        return sessionCoursRepository.findAllByProfesseur(prof);
    }

    @Override
    public SessionCours findById(int id) {
        return sessionCoursRepository.findById(id);
    }

    @Override
    public SessionCours getById(Long id) {
        return sessionCoursRepository.findSessionCoursById(id);
    }


}
