package br.com.astek;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.astek.domain.Categoria;
import br.com.astek.domain.Cidade;
import br.com.astek.domain.Estado;
import br.com.astek.domain.Produto;
import br.com.astek.repositories.CategoriaRepository;
import br.com.astek.repositories.CidadeRepository;
import br.com.astek.repositories.EstadoRepository;
import br.com.astek.repositories.ProdutoRepository;

@SpringBootApplication
public class AulasSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AulasSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// inserindo dados
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "impressora", 200.00);
		Produto p2 = new Produto(null, "monitor", 100.00);
		Produto p3 = new Produto(null, "papel", 15.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado estado1 = new Estado(null, "sao paulo");
		Estado estado2 = new Estado(null, "rio de janeiro");
		
		Cidade cidade1 = new Cidade(null, "Maua",estado1);
		Cidade cidade2 = new Cidade(null, "diadema",estado1);
		Cidade cidade3 = new Cidade(null, "niteroi",estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1,cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
	}
}
