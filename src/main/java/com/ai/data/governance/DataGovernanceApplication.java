package com.ai.data.governance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ai.data.governance.model.DataEntity;
import com.ai.data.governance.repository.DataRepository;

@SpringBootApplication
public class DataGovernanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataGovernanceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DataRepository repository) {
		return (args) -> {
			repository.save(new DataEntity("Anurag", "AI Governance Test"));
		};
	}

}