package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Marca;
import com.lojaunit.services.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping
	public ResponseEntity<List<Marca>> findAll(){
		List<Marca> marca = marcaService.findAll();
		return ResponseEntity.ok().body(marca);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Marca> findById(@PathVariable("id") Long id){
		Marca marca = marcaService.findById(id);
		return ResponseEntity.ok().body(marca);
	}
}
