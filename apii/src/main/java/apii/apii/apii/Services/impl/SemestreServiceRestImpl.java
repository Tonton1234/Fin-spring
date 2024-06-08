package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.SemestreServiceRest;
import apii.apii.apii.dto.request.SemestreRequestDto;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SemestreServiceRestImpl implements SemestreServiceRest {
    private final SemestreRepository semestreRepository;
    @Override
    public void add(SemestreRequestDto dto) {
        Semestre semestre=dto.toEntity();
        semestreRepository.save(semestre);
    }
}
