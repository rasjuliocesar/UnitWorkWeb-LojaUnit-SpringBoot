package com.lojaunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaunit.entities.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long>{

}
