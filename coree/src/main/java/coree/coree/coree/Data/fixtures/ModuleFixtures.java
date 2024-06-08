package coree.coree.coree.Data.fixtures;

import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class ModuleFixtures implements CommandLineRunner {
    private final ModuleService moduleService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Module module=new Module();
            module.setLibelle("Module"+i);
            module.setActive(true);
            moduleService.save(module);
        }
    }
}
