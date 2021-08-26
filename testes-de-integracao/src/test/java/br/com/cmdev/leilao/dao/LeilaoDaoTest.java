package br.com.cmdev.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.leilao.builder.LeilaoBuilder;
import br.com.cmdev.leilao.builder.UsuarioBuilder;
import br.com.cmdev.leilao.model.Leilao;
import br.com.cmdev.leilao.model.Usuario;
import br.com.cmdev.leilao.util.JPAUtil;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void setUp() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	public void destroy() {
		em.getTransaction().rollback();
	}

	@Test
	public void deveriaCadastrarUmLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.nome("fulano")
				.email("fulano@email.com")
				.password("123456").create();
		
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.nome("Notebook")
				.valorInicial("1000")
				.data(LocalDate.now())
				.usuario(usuario).create();
		
		leilao = dao.salvar(leilao);
		
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);
	}
	
	@Test
	public void deveriaAtualizarUmLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.nome("fulano")
				.email("fulano@email.com")
				.password("123456").create();
		
		em.persist(usuario);

		Leilao leilao = new LeilaoBuilder()
				.nome("Notebook")
				.valorInicial("1000")
				.data(LocalDate.now())
				.usuario(usuario).create();
		
		leilao = dao.salvar(leilao);
		
		leilao.setNome("Workstation");
		leilao.setValorInicial(new BigDecimal("3000"));
		
		leilao = dao.salvar(leilao);
		
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertEquals("Workstation", salvo.getNome());
		Assert.assertEquals(new BigDecimal("3000"), salvo.getValorInicial());
	}

}
