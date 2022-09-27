package com.unitycourse.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitycourse.course.entities.Order;
import com.unitycourse.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")  // é o endPoint para pegar os dados da tabela usuarios
public class OrderResource {
	
	@Autowired 		//injecao de dependecia pelo spring data
	private OrderService service; // dependencia para o service
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint com valor do id na tabela
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
