package br.com.cmdev.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		if(browser != null) {
			this.browser = browser;
		}else {
			this.browser = new ChromeDriver();
		}
	}
	
	public void quit() {
		pausaParaFechar();
		this.browser.quit();
	}
	
	private void pausaParaFechar() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
