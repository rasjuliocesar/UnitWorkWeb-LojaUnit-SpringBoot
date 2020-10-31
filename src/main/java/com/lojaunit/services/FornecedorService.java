package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Fornecedor;
import com.lojaunit.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> findAll(){
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.get();
		
		
	}
}
