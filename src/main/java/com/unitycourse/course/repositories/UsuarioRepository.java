package com.unitycourse.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitycourse.course.entities.Usuario;

//jpaRepository é responsavel por fazer operacoes com a classe usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}




