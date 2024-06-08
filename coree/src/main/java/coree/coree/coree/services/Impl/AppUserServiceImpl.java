package coree.coree.coree.services.Impl;

import coree.coree.coree.Data.entities.AppUser;
import coree.coree.coree.Data.repositories.AppRoleRepository;
import coree.coree.coree.Data.repositories.AppUserRepository;
import coree.coree.coree.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public Page<AppUser> getAllUsersByActiveTrue(Pageable pageable) {
        return appUserRepository.findByActiveTrue(pageable);
    }

    @Override
    public void save(AppUser data) {
        appUserRepository.save(data);
    }

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> show(Long dataID) {
        return Optional.empty();
    }
}
