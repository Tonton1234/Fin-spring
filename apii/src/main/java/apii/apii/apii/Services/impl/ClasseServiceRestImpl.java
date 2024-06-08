package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.ClasseServiceRest;
import apii.apii.apii.dto.request.ClasseRequestDto;
import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.repositories.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasseServiceRestImpl implements ClasseServiceRest {
    private final ClasseRepository classeRepository;
    @Override
    public void add(ClasseRequestDto dto) {
        Classe classe=dto.toEntity();
        classe.setActive(true);
        Classe clas=classeRepository.findClasseByLibelle(classe.getLibelle());
        /*if (clas.equals(classe)){

        }*/
        if (clas==null){
            classeRepository.save(classe);
        }

    }
}
