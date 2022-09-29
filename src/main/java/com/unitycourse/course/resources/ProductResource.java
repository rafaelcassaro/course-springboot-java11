package com.unitycourse.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitycourse.course.entities.Product;
import com.unitycourse.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")  // é o endPoint para pegar os dados da tabela usuarios
public class ProductResource {
	
	@Autowired 		//injecao de dependecia pelo spring data
	private ProductService service; // dependencia para o service
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint com valor do id na tabela
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
