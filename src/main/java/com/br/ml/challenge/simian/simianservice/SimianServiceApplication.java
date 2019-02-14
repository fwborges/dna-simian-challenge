package com.br.ml.challenge.simian.simianservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimianServiceApplication implements CommandLineRunner {

	@Autowired
	private Simian simian;

	public static void main(String[] args) {
		SpringApplication.run(SimianServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		simian.isSimian(null);



	}
}

