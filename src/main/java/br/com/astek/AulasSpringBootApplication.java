package br.com.astek;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.astek.domain.Categoria;
import br.com.astek.repositories.CategoriaRepository;

@SpringBootApplication
public class AulasSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(AulasSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//inserindo dados
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}
}
