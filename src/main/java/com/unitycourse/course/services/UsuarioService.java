package com.unitycourse.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitycourse.course.entities.Usuario;
import com.unitycourse.course.repositories.UsuarioRepository;


@Service		//registra a classe como componente do spring para ser injetado com autowired em outra classe
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	// passa a chamada de procurar tds no banco da tabela usuario para o repository
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}

}
