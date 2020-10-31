package com.lojaunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaunit.entities.Faq;
import com.lojaunit.services.FaqService;

@RestController
@RequestMapping(value = "faqs")
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	@GetMapping
	public ResponseEntity<List<Faq>> findAll(){
		List<Faq> faq = faqService.findAll();
		return ResponseEntity.ok().body(faq);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Faq> findById(@PathVariable("id") Long id){
		Faq faq = faqService.findById(id);
		return ResponseEntity.ok().body(faq);
	}
}
