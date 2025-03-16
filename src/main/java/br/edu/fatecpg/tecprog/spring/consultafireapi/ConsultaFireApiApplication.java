package br.edu.fatecpg.tecprog.spring.consultafireapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaFireApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ConsultaFireApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Projeto Iniciado!");
	}
}
