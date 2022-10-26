package com.unitycourse.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unitycourse.course.entities.Usuario;
import com.unitycourse.course.repositories.UsuarioRepository;
import com.unitycourse.course.services.exceptions.DatabaseException;
import com.unitycourse.course.services.exceptions.ResourceNotFoundException;


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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = repository.getReferenceById(id);
			updateData(entity, obj);	//oq vai ser dado upadte pelo metodo
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	
	private void updateData(Usuario entity, Usuario obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
