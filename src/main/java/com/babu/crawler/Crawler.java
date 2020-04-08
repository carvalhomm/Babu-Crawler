package com.babu.crawler;

import org.openqa.selenium.WebDriver;

import com.babu.core.BasePage;

public class Crawler extends BasePage {
	public WebDriver getDriver() {
		return this.driver;
	}

	public void enterPage(String page) {
		this.driver.get(page);
	}
}
