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
	
	public Fornecedor insert(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public void delete(Long id) {
		fornecedorRepository.deleteById(id);
	}
	
	public Fornecedor update(Long id, Fornecedor fornecedor) {
		Fornecedor forn = fornecedorRepository.getOne(id);
		updateData(forn, fornecedor);
		return fornecedorRepository.save(forn);
	}
	
	private void updateData(Fornecedor forn, Fornecedor fornecedor) {
		forn.setNome(fornecedor.getNome());
		forn.setEndereco(fornecedor.getEndereco());
		forn.setTelefone(fornecedor.getTelefone());
		forn.setCnpj(fornecedor.getCnpj());
		forn.setEmail(fornecedor.getEmail());
	}
}
