package site.metacoding.blogv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import site.metacoding.blogv4.domain.user.UserRepository;
import site.metacoding.blogv4.web.UserController;

@EnableJpaAuditing
@SpringBootApplication
public class Blogv4Application {

	public static void main(String[] args) {
		SpringApplication.run(Blogv4Application.class, args);

	}

}