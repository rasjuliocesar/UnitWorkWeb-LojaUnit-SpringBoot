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
	
	public FormaPagamento insert(FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	public void delete(Long id) {
		formaPagamentoRepository.deleteById(id);
	}
	
	public FormaPagamento update(Long id, FormaPagamento formaPagamento) {
		FormaPagamento formaPag = formaPagamentoRepository.getOne(id);
		updateDate(formaPag, formaPagamento);
		return formaPagamentoRepository.save(formaPag);
	}

	private void updateDate(FormaPagamento formaPag, FormaPagamento formaPagamento) {
		formaPag.setForma(formaPagamento.getForma());
		formaPag.setDescricao(formaPagamento.getDescricao());
		formaPag.setAtivo(formaPagamento.getAtivo());
	}
}
