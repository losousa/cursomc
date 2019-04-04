package com.leonardo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.beans.Cliente;
import com.leonardo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarId(Integer id) {
		Optional<Cliente> c = clienteRepository.findById(id);
		return c.orElse(null);
	}

}
