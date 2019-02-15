package com.br.ml.challenge.simian.simianservice;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SimianServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimianServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




	}
}

