package com.unitycourse.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitycourse.course.entities.Product;

//jpaRepository é responsavel por fazer operacoes com a classe usuario
public interface ProductRepository extends JpaRepository<Product, Long> {

}




