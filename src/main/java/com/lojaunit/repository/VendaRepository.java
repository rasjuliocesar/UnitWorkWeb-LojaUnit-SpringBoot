package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
