package com.babu.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;	
		
	public static WebDriver getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
		
	}
	
	private static void createDriver() {				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\teomo\\Desktop\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(24, TimeUnit.SECONDS);						
	}
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}	
	}

}
