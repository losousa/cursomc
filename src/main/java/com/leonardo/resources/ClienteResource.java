package com.leonardo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.beans.Cliente;
import com.leonardo.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		Cliente c = clienteService.buscarId(id);
		return ResponseEntity.ok().body(c);
	}
}
