package br.com.cmdev.selenium.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPageObject pageLogin;

	@BeforeEach
	public void setUpBeforeEach() {
		this.pageLogin = new LoginPageObject();
	}
	
	@AfterEach
	public void setUpAfterEach() {
		pausaParaFechar();
		this.pageLogin.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		pageLogin.preencherFormularioLogin("fulano", "pass");
		pageLogin.efetuarLogin();
		
		Assert.assertFalse(pageLogin.isPaginaUsuarioLogado());
		Assert.assertEquals("fulano", pageLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		pageLogin.preencherFormularioLogin("test", "123");
		pageLogin.efetuarLogin();
		
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

	private void pausaParaFechar() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
}
