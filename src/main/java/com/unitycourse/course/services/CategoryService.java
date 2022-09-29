package com.unitycourse.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitycourse.course.entities.Category;
import com.unitycourse.course.repositories.CategoryRepository;


@Service		//registra a classe como componente do spring para ser injetado com autowired em outra classe
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	// passa a chamada de procurar tds no banco da tabela usuario para o repository
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	

}
