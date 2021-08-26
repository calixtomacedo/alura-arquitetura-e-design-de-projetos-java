package br.com.cmdev.selenium.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	@BeforeAll 
	public static void setUpBeforeAll() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	}
	
	@BeforeEach
	public void setUpBeforeEach() {
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}
	
	@AfterEach
	public void setUpAfterEach() {
		pausaParaFechar();
		this.browser.quit();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();
		
		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertEquals("fulano", browser.findElement(By.id("user-logado")).getText());
		
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		browser.findElement(By.id("username")).sendKeys("test");
		browser.findElement(By.id("password")).sendKeys("1234");
		browser.findElement(By.id("login-form")).submit();
		
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("user-logado")));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemLogar() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		
		Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

	private void pausaParaFechar() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
}
