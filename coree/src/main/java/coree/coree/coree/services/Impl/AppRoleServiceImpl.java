package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.AnneeScolaire;
import coree.coree.coree.Data.entities.AppRole;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.services.AppRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AppRoleServiceImpl implements AppRoleService {
    private final AppRoleRepository appRoleRepository;

    @Override
    public Page<AppRole> getAllRoleByActiveTrue(Pageable pageable) {
        return appRoleRepository.findByActiveTrue(pageable);
    }

    @Override
    public void save(AppRole data) {
        appRoleRepository.save(data);
    }

    @Override
    public List<AppRole> getAll() {
        return null;
    }

    @Override
    public Optional<AppRole> show(Long dataID) {
        return Optional.empty();
    }
}
