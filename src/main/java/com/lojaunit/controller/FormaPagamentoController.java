package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
