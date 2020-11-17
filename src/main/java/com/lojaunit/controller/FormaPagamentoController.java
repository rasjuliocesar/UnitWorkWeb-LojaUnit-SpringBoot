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

import com.lojaunit.entities.FormaPagamento;
import com.lojaunit.services.FormaPagamentoService;

@RestController
@RequestMapping(value = "/formaspagamento")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@GetMapping
	public ResponseEntity<List<FormaPagamento>> findAll(){
		List<FormaPagamento> formaPagamento = formaPagamentoService.findAll();
		return ResponseEntity.ok().body(formaPagamento);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FormaPagamento> findById(@PathVariable("id") Long id){
		FormaPagamento formaPagamento = formaPagamentoService.findById(id);
		return ResponseEntity.ok().body(formaPagamento);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<FormaPagamento> insert(@RequestBody FormaPagamento formaPagamento){
		formaPagamento = formaPagamentoService.insert(formaPagamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(formaPagamento.getId()).toUri();
		return ResponseEntity.created(uri).body(formaPagamento);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		formaPagamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento){
		formaPagamento = formaPagamentoService.update(id, formaPagamento);
		return ResponseEntity.ok().body(formaPagamento);
	}
}
