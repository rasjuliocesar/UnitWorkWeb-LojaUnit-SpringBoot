package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
