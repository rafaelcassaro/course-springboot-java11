package com.unitycourse.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitycourse.course.entities.Order;
import com.unitycourse.course.repositories.OrderRepository;


@Service		//registra a classe como componente do spring para ser injetado com autowired em outra classe
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	// passa a chamada de procurar tds no banco da tabela usuario para o repository
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	

}
