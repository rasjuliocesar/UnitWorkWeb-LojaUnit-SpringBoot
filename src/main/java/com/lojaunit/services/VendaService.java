package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Venda;
import com.lojaunit.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> findAll(){
		return vendaRepository.findAll();
	}
	
	public Venda findById(Long id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		return venda.get();
	}
}
