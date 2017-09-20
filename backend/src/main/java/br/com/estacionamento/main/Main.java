package br.com.estacionamento.main;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Flyway flyway = new Flyway();
		flyway.setDataSource(ApplicationConfiguration.getDatabaseUrl(), null, null);
		flyway.migrate();
	}
}
