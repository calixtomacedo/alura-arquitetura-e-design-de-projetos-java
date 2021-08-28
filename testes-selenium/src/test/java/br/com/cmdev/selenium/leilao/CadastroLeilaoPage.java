package br.com.cmdev.selenium.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.cmdev.selenium.PageObject;

public class CadastroLeilaoPage extends PageObject {

	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	
	public CadastroLeilaoPage(WebDriver browser) {
		super(browser);
	}
	
	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		browser.findElement(By.id("nome")).sendKeys(nome);
		browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		browser.findElement(By.id("button-submit")).click();
		
		return new LeiloesPage(browser);
	}

	public boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().equals(URL_CADASTRO_LEILOES);
	}

	public boolean mensagensDeValidacaoNotHidden() {
		String pageSource = this.browser.getPageSource();
		boolean validate = (pageSource.contains("minimo 3 caracteres") 
				&& pageSource.contains("não deve estar em branco") 
				&& pageSource.contains("deve ser um valor maior de 0.1") 
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy"));

		return validate;
	}

}
