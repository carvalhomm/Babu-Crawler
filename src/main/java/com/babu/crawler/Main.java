package com.babu.crawler;

import org.openqa.selenium.By;

public class Main {
	
	public static void main(String args[]) {
		Crawler crawler = new Crawler();
		crawler.enterPage("https://gshow.globo.com/realities/bbb/");
		crawler.enterVotacao(By.className("bstn-hl type-enquete with-photo with-chapeu"));
		crawler.selecionaCandidato(By.className("_3_xVTlDqedwj53qq7UdnrX"));
	}

}
