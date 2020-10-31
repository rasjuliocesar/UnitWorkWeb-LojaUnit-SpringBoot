package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
