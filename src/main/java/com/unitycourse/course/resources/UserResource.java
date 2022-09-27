package com.unitycourse.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitycourse.course.entities.Usuario;
import com.unitycourse.course.services.UsuarioService;

@RestController
@RequestMapping(value = "/users")  // é o endPoint para pegar os dados da tabela usuarios
public class UserResource {
	
	@Autowired 		//injecao de dependecia pelo spring data
	private UsuarioService service; // dependencia para o service
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //endpoint com valor do id na tabela
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
