package apii.apii.apii.Services.impl;

import apii.apii.apii.Services.ModuleServiceRest;
import apii.apii.apii.dto.request.ModuleRequestDto;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ModuleServiceRestImpl implements ModuleServiceRest {
    private final ModuleRepository moduleRepository;
    @Override
    public void add(ModuleRequestDto dto) {
        Module module =dto.toEntity();
        module.setActive(true);
        String nom= module.getLibelle().toUpperCase() ;
        module.setLibelle(nom);
        Module acM=moduleRepository.findFirstByLibelle(nom);

        if (!module.equals(acM)){
            System.out.println("ok");
            moduleRepository.save(module);
        }else{
            System.out.println("faux");
        }
    }
}
