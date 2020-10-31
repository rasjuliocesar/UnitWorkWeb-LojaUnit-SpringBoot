package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.FormaPagamento;
import com.lojaunit.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public List<FormaPagamento> findAll(){
		return formaPagamentoRepository.findAll();
	}
	
	public FormaPagamento findById(Long id) {
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
		return formaPagamento.get();
	}
}
