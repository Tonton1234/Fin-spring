package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.AnneeScolaireRequestService;
import apii.apii.apii.dto.request.AnneeScolaireRequestDto;
import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.repositories.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnneeScolaireRequestServiceImpl implements AnneeScolaireRequestService {
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void add(AnneeScolaireRequestDto dto) {
        AnneeScolaire anneeScolaire=dto.toEntity();
        anneeScolaire.setActive(false);
        anneeScolaireRepository.save(anneeScolaire);
    }

}
