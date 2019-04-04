package com.leonardo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.beans.Categoria;
import com.leonardo.repository.CategoriaRepository;
import com.leonardo.service.exceptions.ObjetoNaoEncontrado;

//Definir que é uma Service
//Representar o servico do controller com REST
@Service
public class CategoriaService {

	//Puxar os dados do Repository para o CRUD
	//Injeta uma dependencia automaticamente do Repository.
	@Autowired
	private CategoriaRepository repo;
	
	//Buscar uma categoria por ID do tipo Categoria
	public Categoria buscarPorIdd(Integer id) {
		Optional<Categoria> cat = repo.findById(id);
		
		//Caso exista mostrar o nome, caso não exista mostrar a mensagem personalizada da classe ObjetoNaoEncontrado.
		return cat.orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! Id: " + id + ", Tipo: "
		+ Categoria.class.getName()));
	}
}



