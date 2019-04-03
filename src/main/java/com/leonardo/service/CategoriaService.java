package com.leonardo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.beans.Categoria;
import com.leonardo.repository.CategoriaRepository;

//Definir que é uma Service
//Representar o servico do controller com REST
@Service
public class CategoriaService {

	//Puxar os dados do Repository para o CRUD
	//Injeta uma dependencia automaticamente do Repository.
	@Autowired
	private CategoriaRepository repo;
	
	//Buscar uma categoria por ID do tipo Categoria
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> cat = repo.findById(id);
		return cat.orElse(null);
	}
}
