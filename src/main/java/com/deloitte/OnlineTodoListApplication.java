package com.deloitte;

import com.deloitte.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class OnlineTodoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineTodoListApplication.class, args);
	}

}
