package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Faq;
import com.lojaunit.repository.FaqRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;
	
	public List<Faq> findAll(){
		return faqRepository.findAll();
	}
	
	public Faq findById(Long id) {
		Optional<Faq> faq = faqRepository.findById(id);
		return faq.get();
	}
}
