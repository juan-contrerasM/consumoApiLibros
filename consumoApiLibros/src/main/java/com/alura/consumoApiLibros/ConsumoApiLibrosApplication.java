package com.alura.consumoApiLibros;

import com.alura.consumoApiLibros.controller.LibrosController;
import com.alura.consumoApiLibros.principal.Principal;
import com.alura.consumoApiLibros.service.AutorRepository;
import com.alura.consumoApiLibros.service.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumoApiLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiLibrosApplication.class, args);
	}
	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void run(String... args) throws Exception {
		Principal principal= new Principal(libroRepository, autorRepository);
		principal.consumirApi();
	}

}
