package com.leonardo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.beans.Categoria;

//Recursos para o Rest
//Nome certo da classe para a utilização.(Categoria)
//Controlador pra saber qual caminho da aplicação é utilizado.
@RestController
//Mapear o link para utilização de informações desta classe. Ex : localhost:8080/categorias
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//Método que vai retornar algo. GET = retornar/mostrar informações.
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria categoria = new Categoria(1,"Informatica");
		List<Categoria> list = new ArrayList<>();
		list.add(categoria);
		
		return list;
	}

	
}
