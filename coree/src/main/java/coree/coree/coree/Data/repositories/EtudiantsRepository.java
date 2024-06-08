package coree.coree.coree.Data.repositories;

import coree.coree.coree.Data.entities.Cours;
import coree.coree.coree.Data.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantsRepository extends JpaRepository<Etudiant,Long> {

    //Redéfinition de la méthode findAll
    @Override
    Page<Etudiant> findAll(Pageable pageable);

    Etudiant findByNom(String nom);

    Page<Etudiant> findEtudiantByActiveTrue(Pageable pageable);
    /*
    @Query("SELECT e FROM Etudiant e JOIN e.cours c WHERE c.id = :coursId")
    List<Etudiant> getEtudiantsByCoursId(@Param("coursId") Long coursId);

    @Query("SELECT e FROM Etudiant e JOIN e.classes c WHERE c.id = :classesId")
    List<Etudiant> getEtudiantsByClassesId(@Param("classesId") Long classesId);*/

}
