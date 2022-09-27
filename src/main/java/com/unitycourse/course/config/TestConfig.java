package com.unitycourse.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unitycourse.course.entities.Usuario;
import com.unitycourse.course.repositories.UsuarioRepository;


@Configuration
@Profile("test") //esse perfil "test" ta no ..main/resources/application.properties 
public class TestConfig implements CommandLineRunner { //CommandLineRunner é pra executar quando iniciar a app
	
	@Autowired
	private UsuarioRepository usuarioRepository; // fazer comandos p/ o banco de dados

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2)); // salvar lista de objs no banco
	}

}
