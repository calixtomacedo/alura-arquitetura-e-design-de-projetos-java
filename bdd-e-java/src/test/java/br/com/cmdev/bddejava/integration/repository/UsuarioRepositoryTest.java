package br.com.cmdev.bddejava.integration.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.cmdev.bddejava.integration.controller.TestBase;
import br.com.cmdev.bddejava.model.Usuario;
import br.com.cmdev.bddejava.repositories.UsuarioRepository;

@DataJpaTest
@ActiveProfiles("test") 
public class UsuarioRepositoryTest extends TestBase{

	@Autowired
	UsuarioRepository usuarios;
	
	@BeforeEach
	public void setup() {
		usuarios.saveAndFlush(this.getUsuarioFulano());
	}
	
	@Test
	public void deveCarregarUmUsuarioPeloNome() {
		Usuario usuarioCarregado = usuarios.getUserByUsername("Fulano");
		Assertions.assertEquals(this.getUsuarioFulano(), usuarioCarregado);
	}
}
