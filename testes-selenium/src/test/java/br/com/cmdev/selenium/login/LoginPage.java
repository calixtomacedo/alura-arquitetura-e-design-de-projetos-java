package br.com.cmdev.selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.cmdev.selenium.PageObject;
import br.com.cmdev.selenium.leilao.LeiloesPage;

public class LoginPage extends PageObject {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN);
	}

	private void preencherFormularioLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuarLogin(String username, String password) {
		this.preencherFormularioLogin(username, password);
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isPaginaUsuarioLogado() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("user-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void navegarParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean verificarContemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isPaginaUsuarioInvalido() {
		return browser.getCurrentUrl().equals(URL_LOGIN.concat("?error"));
	}

}
