package com.babu.crawler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.babu.core.BasePage;

public class Crawler extends BasePage {
	public WebDriver getDriver() {
		return this.driver;
	}

	public void enterPage(String page) {
		this.driver.get(page);
	}
	
	public void enterVotacao(By identifier) {
		try {			
			this.wait(4000);
		} catch (Exception excp) {
			System.out.println("wait exception --> " + excp.getMessage());
		}
		this.esperaAparecer(identifier);
		this.clique(identifier);
	}
	
	public void selecionaCandidato(By identifier) {
		this.esperaAparecer(identifier);
		WebElement selecionado = null;
		List<WebElement> candidatos = this.getListagem(identifier);
		for (WebElement candidato : candidatos) {
			if (candidato.getText().contains("Babu")) {
				continue;
			}
			candidato.click();
			selecionado = candidato;
			break;
		}
		this.bypassCaptcha(4, selecionado);
	}
	
	private void bypassCaptcha(int votacaoPosition, WebElement candidato) {
		int imageDivisor = 54 * votacaoPosition;
		WebElement imagem = candidato.findElement(By.tagName("img"));
		this.cliqueByCoordinates(imagem, imageDivisor, 20);
	}
}
