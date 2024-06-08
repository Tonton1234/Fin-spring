package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.SalleServiceRest;
import apii.apii.apii.dto.request.SalleRequestDto;
import coree.coree.coree.Data.entities.SallesDeCours;
import coree.coree.coree.Data.repositories.SallesCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalleServiceRestImpl implements SalleServiceRest {
    private final SallesCoursRepository sallesCoursRepository;
    @Override
    public void add(SalleRequestDto dto) {
        SallesDeCours salle=dto.toEntity();
        String nom= salle.getNom().toUpperCase() ;
        String numero= salle.getNumero().toUpperCase() ;
        salle.setNom(nom);
        salle.setNumero(numero);
        salle.setActive(true);
        SallesDeCours sl=sallesCoursRepository.findFirstByNumero(salle.getNumero());

        if (!salle.equals(sl)){
            sallesCoursRepository.save(salle);
        }
    }
}
