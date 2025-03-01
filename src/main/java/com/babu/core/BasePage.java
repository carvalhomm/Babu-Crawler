package com.babu.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver = DriverFactory.getDriver();
	public WebDriverWait wait = new WebDriverWait(driver, 42);
	public JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		
	public void escrever(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}
	
	public void cliqueByCoordinates(WebElement reference, int x, int y) {
		Actions builder = new Actions(driver);   
		builder.moveToElement(reference, x, y).click().build().perform();
	}
	
	public List<WebElement> getListagem(By identifier) {
		WebElement votacaoGroup = driver.findElement(identifier);
		List<WebElement> lista = votacaoGroup.findElements(By.className("_3HY6tUrdeykwokPXP7PdwT"));
		return lista;
	}
	
	public void clique(By by) {
		driver.findElement(by).click();
	}
	
	public void entraFocoJanelaPrincipal() {
		String janela = (String) driver.getWindowHandles().toArray()[0];
		driver.switchTo().window(janela);
	}	
	
	public void entraFocoJanelaAuxiliar() {
		String janela = (String) driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(janela);
	}
	
	public void fechaJanelaAtual() {
		driver.close();
	}	
	
	public void executarJavaScript(String comando, Object obj){
		js.executeScript(comando, obj);
	}
	
	public String retornaTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public void esperaDesaparecer(By by) {		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void esperaAparecer(By by) {		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
