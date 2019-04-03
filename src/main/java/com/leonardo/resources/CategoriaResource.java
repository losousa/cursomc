package com.leonardo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.beans.Categoria;
import com.leonardo.service.CategoriaService;

//Recursos para o Rest
//Nome certo da classe para a utilização.(Categoria)
//Controlador pra saber qual caminho da aplicação é utilizado.
@RestController
//Mapear o link para utilização de informações desta classe. Ex : localhost:8080/categorias
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	//Puxar o método de Buscar feito na camada de servico e instanciar na classe REST/Resource.
	private CategoriaService service;
	
	//Método que vai retornar algo. GET = retornar/mostrar informações.
	//Acessar por um ID existente para retornar os atributos da Categoria.
	//Passar pelo localhost:8080/categorias/id substituindo o /id por um ID existente
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	//Passando por parametro @PathVariable pra associar com o value {ID}
	//necessário para fazer a busca pelo localhost:8080/categorias/(id)
	//Encapsula,armazena varias informações HTTP para o serviço REST. ? = encontrar ou não encontrar uma categoria
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){

		Categoria cat = service.buscarPorId(id);
		//O corpo/body do responseEntity vai ser as informações do ID
		//elocalizadas pelo localhost:8080/categorias/{id} colocado ex /1
		return ResponseEntity.ok().body(cat);
	}

	
}
