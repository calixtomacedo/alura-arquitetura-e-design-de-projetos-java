package br.com.cmdev.selenium.leilao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.selenium.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage leiloesPage;
	private CadastroLeilaoPage cadastroLeilaoPage;
	
	@BeforeEach
	public void setUpBeforeEach() {
		LoginPage loginPage = new LoginPage();
		this.leiloesPage = loginPage.efetuarLogin("fulano", "pass");
		this.cadastroLeilaoPage = this.leiloesPage.carregarFormularioLeilao();
	}

	@AfterEach
	public void setUpAfterEach() {
		this.leiloesPage.quit();
		this.cadastroLeilaoPage.quit();
	}
	

	@Test
	public void deveriaCadastrarUmLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia "+ hoje;
		String valor = "500.00";
		this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(leiloesPage.isLeilaoCadastrodo(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastrarDeLeilao() {
		this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao("", "", "");
		
		Assert.assertFalse(this.cadastroLeilaoPage.isPaginaAtual());
		Assert.assertTrue(this.leiloesPage.isPaginaAtual());
		Assert.assertTrue(this.cadastroLeilaoPage.mensagensDeValidacaoNotHidden());
	}
}
