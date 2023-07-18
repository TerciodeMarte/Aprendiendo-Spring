package com.cafeconpalito.springsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String hashedPassword = passwordEncoder.encode("admin");

		User user = new User(null,"juan",hashedPassword);

		repository.save(user);

	}

}
