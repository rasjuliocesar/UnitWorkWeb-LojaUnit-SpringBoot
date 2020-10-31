package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
