package com.lojaunit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping(value = "/add")
	public ResponseEntity<Marca> insert(@RequestBody Marca marca){
		marca = marcaService.insert(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getId()).toUri();
		return ResponseEntity.created(uri).body(marca);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		marcaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Marca> update(@PathVariable Long id, @RequestBody Marca marca){
		marca = marcaService.update(id, marca);
		return ResponseEntity.ok().body(marca);
	}
}
