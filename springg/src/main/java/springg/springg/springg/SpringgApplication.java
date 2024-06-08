package springg.springg.springg;

import coree.coree.coree.Data.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@AllArgsConstructor
@SpringBootApplication(scanBasePackages = {"coree.coree.coree","springg.springg.springg"})
public class SpringgApplication implements CommandLineRunner {
	private final AppUserRepository appUserRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
