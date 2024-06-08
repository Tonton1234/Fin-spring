package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.Enum.EtatSessionCours;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {

    List<SessionCours> getByEtat(EtatSessionCours etatSessionCours);
    Page<SessionCours> getByEtat(EtatSessionCours etatSessionCours, Pageable pageable);
    Page<SessionCours> findByActiveTrue(Pageable pageable);
    Page<SessionCours> findByCoursIdAndAndActiveTrue (Long id,Pageable pageable);
    Page<SessionCours> findAllByProfesseur(Professeur professeur, Pageable pageable);
    List<SessionCours> findAllByProfesseur(AppUser professeur);
    Page<SessionCours> getByModule(Module module, Pageable pageable);

    Page<SessionCours> findAllByActiveTrueAndDate(LocalDate date, Pageable pageable);
    List<SessionCours> findAllByActiveTrueAndDate(LocalDate date);
    Page<SessionCours> findAllByActiveTrueAndModule(Module module, Pageable pageable);
    List<SessionCours> findAllByActiveTrueAndModule(Module module);
    SessionCours findSessionCoursById(Long id);
    //sans la pagination
    @Query("SELECT c from SessionCours c JOIN c.professeur p WHERE p.id = :profId")
    List<SessionCours> getByProfesseurId(@Param("profId") Long profId);


    SessionCours findById(int i);

}
