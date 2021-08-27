package br.com.cmdev.selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageObject {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPageObject() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}

	public void quit() {
		this.browser.quit();
	}

	public void preencherFormularioLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();
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
