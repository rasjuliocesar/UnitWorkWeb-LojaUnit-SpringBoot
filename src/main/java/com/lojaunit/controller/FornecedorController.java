package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Fornecedor;
import com.lojaunit.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll(){
		List<Fornecedor> fornecedor = fornecedorService.findAll();
		return ResponseEntity.ok().body(fornecedor);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable("id") Long id){
		Fornecedor fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok().body(fornecedor);
	}
}
