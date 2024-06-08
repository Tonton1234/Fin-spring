package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.ProfesseurServiceRest;
import apii.apii.apii.dto.request.ProfesseurRequestDto;
import coree.coree.coree.Data.entities.Professeur;
import coree.coree.coree.Data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceRestImpl implements ProfesseurServiceRest {
    private final ProfesseurRepository professeurRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void add(ProfesseurRequestDto dto) {
        Professeur professeur=dto.toEntity();
        professeur.setPassword(passwordEncoder.encode("passer"));
        professeur.setActive(true);
        professeurRepository.save(professeur);

    }
}
