package com.unitycourse.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitycourse.course.entities.OrderItem;

//jpaRepository é responsavel por fazer operacoes com a classe usuario
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}




