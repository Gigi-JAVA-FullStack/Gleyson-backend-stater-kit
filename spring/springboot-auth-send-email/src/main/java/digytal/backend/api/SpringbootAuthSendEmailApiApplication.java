package digytal.backend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAuthSendEmailApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthSendEmailApiApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("UserP@ss"));
		//System.out.println(new BCryptPasswordEncoder().encode("M@nager"));
	}


}
