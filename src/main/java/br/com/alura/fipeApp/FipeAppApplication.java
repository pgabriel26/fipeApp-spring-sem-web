package br.com.alura.fipeApp;

import br.com.alura.fipeApp.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.iniciarApp();
	}
}
