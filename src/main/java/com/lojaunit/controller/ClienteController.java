package com.lojaunit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Cliente;
import com.lojaunit.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Cliente>> findById(@PathVariable("id") Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
}
