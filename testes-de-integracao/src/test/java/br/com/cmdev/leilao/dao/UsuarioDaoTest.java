package br.com.cmdev.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.leilao.builder.UsuarioBuilder;
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
		Usuario usuario = new UsuarioBuilder().nome("fulano").email("fulano@email.com").password("123456").create();
		em.persist(usuario);
		Assert.assertNotNull(usuario);
	}

	@Test
	public void naoDeveriaRetornarUmUsuarioPassandoComoParametroOUserName() {
		Usuario usuario = new UsuarioBuilder().nome("fulano").email("fulano@email.com").password("123456").create();
		em.persist(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("baltrano"));
	}

	@Test
	public void deveriaRemoverOUsuarioPassadoComoParametro() {
		Usuario usuario = new UsuarioBuilder().nome("fulano").email("fulano@email.com").password("123456").create();
		em.persist(usuario);
		dao.deletar(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));
	}
	
}
