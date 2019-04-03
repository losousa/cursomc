package com.leonardo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardo.beans.Categoria;
import com.leonardo.beans.Produto;
import com.leonardo.repository.CategoriaRepository;
import com.leonardo.repository.ProdutoRepository;

//Classe que vai fazer a aplicação funcionar
//Porta 8080. localhost:8080
@SpringBootApplication

//Implementa métodos pra toda vez que o programa rodar, fazer o que esta no método.
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private ProdutoRepository pro;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		//Instanciando os Produtos dizendo em qual categoria eles pertencem.
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
	 	//Falando qual categoria cada produto pertence.
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		pro.saveAll(Arrays.asList(p1,p2,p3));
	}

}
