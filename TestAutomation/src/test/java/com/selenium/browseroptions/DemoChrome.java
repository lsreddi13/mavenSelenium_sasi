package com.selenium.browseroptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoChrome {
	@Test
	public void testLoginActionsClass() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
				
				
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver1 = new ChromeDriver(options);
		try {
			// Navigate to Url
			driver1.get("https://google.com");
		} finally {
			driver1.quit();
		}
	}
}
