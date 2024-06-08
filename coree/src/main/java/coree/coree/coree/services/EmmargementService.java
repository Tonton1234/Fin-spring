package coree.coree.coree.services;

import coree.coree.coree.Data.entities.Emargement;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface EmmargementService extends Service<Emargement,Long>{
    Page<Emargement> getAllEmmargementByActiveTrue(Pageable pageable);
    Page<Emargement> getAllEmmargementByActiveTrueAndDate(LocalDate date,Pageable pageable);
    Emargement getById(int id);
}
