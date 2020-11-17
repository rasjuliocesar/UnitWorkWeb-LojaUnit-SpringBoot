package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Categoria;
import com.lojaunit.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Long id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.get();
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public Categoria update(Long id, Categoria categoria) {
		Categoria cat = categoriaRepository.getOne(id);
		updateData(cat, categoria);
		return categoriaRepository.save(cat);
	}

	private void updateData(Categoria cat, Categoria categoria) {
		cat.setNome(categoria.getNome());
		cat.setAtivo(categoria.getAtivo());
	}
}
