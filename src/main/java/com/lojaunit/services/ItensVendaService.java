package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.ItensVenda;
import com.lojaunit.repository.ItensVendaRepository;

@Service
public class ItensVendaService {

	@Autowired
	private ItensVendaRepository itensVendaRepository;
	
	public List<ItensVenda> findAll(){
		return itensVendaRepository.findAll();
	}
	
	public ItensVenda findById(Long id) {
		Optional<ItensVenda> itensVenda = itensVendaRepository.findById(id);
		return itensVenda.get();
	}
}
