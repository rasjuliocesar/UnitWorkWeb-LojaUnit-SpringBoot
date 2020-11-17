package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Marca;
import com.lojaunit.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> findAll(){
		return marcaRepository.findAll();
	}
	
	public Marca findById(Long id) {
		Optional<Marca> marca = marcaRepository.findById(id);
		return marca.get();
	}
	
	public Marca insert(Marca marca) {
		return marcaRepository.save(marca);
	}
	
	public void delete(Long id) {
		marcaRepository.deleteById(id);
	}
	
	public Marca update(Long id, Marca marca) {
		Marca mar = marcaRepository.getOne(id);
		updateData(mar, marca);
		return marcaRepository.save(mar);
	}

	private void updateData(Marca mar, Marca marca) {
		mar.setNome(marca.getNome());
		mar.setDescricao(marca.getDescricao());
	}
}
