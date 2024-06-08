package apii.apii.apii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"coree.coree.coree","apii.apii.apii"})
public class ApiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiiApplication.class, args);
	}

}
