package site.metacoding.blogv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Blogv4Application {

	public static void main(String[] args) {
		SpringApplication.run(Blogv4Application.class, args);
	}

}
