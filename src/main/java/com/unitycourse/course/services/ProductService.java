package com.unitycourse.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitycourse.course.entities.Product;
import com.unitycourse.course.repositories.ProductRepository;


@Service		//registra a classe como componente do spring para ser injetado com autowired em outra classe
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// passa a chamada de procurar tds no banco da tabela usuario para o repository
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	

}
