package com.unitycourse.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitycourse.course.entities.Category;
import com.unitycourse.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")  // é o endPoint para pegar os dados da tabela usuarios
public class CategoryResource {
	
	@Autowired 		//injecao de dependecia pelo spring data
	private CategoryService service; // dependencia para o service
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint com valor do id na tabela
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
