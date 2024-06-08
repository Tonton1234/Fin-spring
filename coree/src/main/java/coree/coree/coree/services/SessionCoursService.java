package coree.coree.coree.services;

import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.entities.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SessionCoursService extends Service<SessionCours,Long>{
    Page<SessionCours> getAllByActiveTrue(Pageable pageable);
    Page<SessionCours> getAllByDate(LocalDate date, Pageable pageable);
    List<SessionCours> getAllByDate(LocalDate date);
    Page<SessionCours> getAllByModule(Module module, Pageable pageable);
    Page<SessionCours> getAllByCoursId(Long id, Pageable pageable);

    List<SessionCours> getAllByModule(Module module);
    Page<SessionCours> getAllByProfesseur(Professeur prof, Pageable pageable);

    List<SessionCours> getAllByProfesseur(AppUser prof);

    SessionCours findById(int id);
    SessionCours getById(Long id);
}
