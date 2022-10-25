package com.unitycourse.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//endpoint com valor do id na tabela
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// metodo http POST p insercao @RequestBody é p transaformar o json q vem do http p obj no java
	@PostMapping
	public ResponseEntity<Usuario> insert (@RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);	//created(espera um obj uri) para voltar o voltar o padrao http certo 
	}
	
	@DeleteMapping(value = "/{id}")  //anotacao do spring boot para delecao 
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") 
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
