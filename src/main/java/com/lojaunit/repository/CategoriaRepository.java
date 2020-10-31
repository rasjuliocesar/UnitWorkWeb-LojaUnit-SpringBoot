package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
