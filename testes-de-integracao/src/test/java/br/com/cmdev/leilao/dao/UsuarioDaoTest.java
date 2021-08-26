package br.com.cmdev.leilao.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
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
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void destroy() {
		em.getTransaction().rollback();
	}

	@Test
	public void deveriaRetornarUmUsuarioPassandoComoParametroOUserName() {
		Usuario usuario = createUser();
		assertNotNull(usuario);
	}
	
	@Test
	public void naoDeveriaRetornarUmUsuarioPassandoComoParametroOUserName() {
		createUser();
		assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("baltrano"));
	}
	
	private Usuario createUser() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "123456");
		em.persist(usuario);
		return usuario;
	}
	

}
