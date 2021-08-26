package br.com.cmdev.leilao.dao;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.leilao.model.Usuario;
import br.com.cmdev.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	
	private EntityManager em;
	
	@BeforeEach
	public void setUp() {
		this.em = JPAUtil.getEntityManager();
	}
	
	@Test
	void deveriaRetornarUmUsuarioPassandoComoParametroOUserName() {
		this.dao = new UsuarioDao(em);

		Usuario usuario = new Usuario("fulano", "fulano@email.com", "123456");
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		Usuario usuarioEncotrado = this.dao.buscarPorUsername("fulano");
		assertNotNull(usuarioEncotrado);
		em.close();
	}

}
