package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Venda;
import com.lojaunit.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> venda = vendaService.findAll();
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable("id") Long id){
		Venda venda = vendaService.findById(id);
		return ResponseEntity.ok().body(venda);
	}
}
