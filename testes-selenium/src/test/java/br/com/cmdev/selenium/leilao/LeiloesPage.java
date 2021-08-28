package br.com.cmdev.selenium.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.cmdev.selenium.PageObject;

public class LeiloesPage extends PageObject {

	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	
	public CadastroLeilaoPage carregarFormularioLeilao() {
		this.browser.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrodo(String nome, String valorInicial, String dataAbertura) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#table-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(dataAbertura) && colunaValorInicial.getText().equals(valorInicial);
	}

	public boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().equals(URL_LEILOES);
	}
}
