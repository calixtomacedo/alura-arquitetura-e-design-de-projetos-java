package br.com.cmdev.selenium.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage pageLogin;

	@BeforeEach
	public void setUpBeforeEach() {
		this.pageLogin = new LoginPage();
	}
	
	@AfterEach
	public void setUpAfterEach() {
		this.pageLogin.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		pageLogin.efetuarLogin("fulano", "pass");
		
		Assert.assertFalse(pageLogin.isPaginaUsuarioLogado());
		Assert.assertEquals("fulano", pageLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		pageLogin.efetuarLogin("test", "123");
		
		Assert.assertTrue(pageLogin.isPaginaUsuarioInvalido());
		Assert.assertNull(pageLogin.getNomeUsuarioLogado());
		Assert.assertTrue(pageLogin.verificarContemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemLogar() {
		pageLogin.navegarParaPaginaDeLances();
		
		Assert.assertTrue(pageLogin.isPaginaUsuarioLogado());
		Assert.assertFalse(pageLogin.verificarContemTexto("Dados do Leilão"));
	}
	
}

