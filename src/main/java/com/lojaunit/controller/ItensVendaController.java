package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.ItensVenda;
import com.lojaunit.services.ItensVendaService;

@RestController
@RequestMapping(value = "/itensvendas")
public class ItensVendaController {

	@Autowired
	private ItensVendaService itensVendaService;
	
	@GetMapping
	public ResponseEntity<List<ItensVenda>> findAll(){
		List<ItensVenda> itensVenda = itensVendaService.findAll();
		return ResponseEntity.ok().body(itensVenda);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItensVenda> findById(@PathVariable("id") Long id){
		ItensVenda itensVenda = itensVendaService.findById(id);
		return ResponseEntity.ok().body(itensVenda);
	}
}
