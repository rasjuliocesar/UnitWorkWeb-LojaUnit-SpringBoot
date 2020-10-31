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
}
