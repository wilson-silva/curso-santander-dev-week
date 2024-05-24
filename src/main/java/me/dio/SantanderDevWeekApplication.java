package me.dio;

import lombok.RequiredArgsConstructor;
import me.dio.domain.model.Account;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SantanderDevWeekApplication  {


	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeekApplication.class, args);
	}

}
