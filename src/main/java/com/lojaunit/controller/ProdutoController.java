package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Produto;
import com.lojaunit.services.ProdutoService;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produto = produtoService.findAll();
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable("id") Long id){
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}
}
