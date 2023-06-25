package digytal.backend.api;

import digytal.backend.api.infra.email.SendEmail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAuthSendEmailApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthSendEmailApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(SendEmail sendEmail) throws Exception {
		return args -> {


		};
	}
}
