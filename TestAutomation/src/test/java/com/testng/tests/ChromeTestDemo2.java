package com.testng.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTestDemo2 {
	WebDriver driver;

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	@BeforeClass
	public void openBrowser() {
		System.out.println("open browser chrome browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("open applicaiton");
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}

	@BeforeMethod
	public void login() {
		System.out.println("Login as user");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUsername")));

		WebElement userName = driver.findElement(By.id("txtUsername"));// xpath
		userName.clear();
		userName.sendKeys("Admin");

		WebElement pwd = driver.findElement(By.name("txtPassword"));
		pwd.clear();
		pwd.sendKeys("admin123");

//		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		WebElement loginBtn = driver.findElement(By.className("button"));
		loginBtn.click();
	}

	@AfterMethod
	public void testLogout() {
		System.out.println("Logout as user");
		driver.findElement(By.id("welcome")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		driver.findElement(By.linkText("Logout")).click();

	}

	@Test(priority = 1, enabled = true)
	public void testVerifyDashboard() {
		System.out.println("Verify Dashboard page");
		String dashboardTitle = driver.getTitle();
		System.out.println("Dashboard page title : " + dashboardTitle);
	}

	@Test(priority = 3, enabled = false )
	public void testVerifyPIM() {
		System.out.println("Verify PIM page");
		// click PIM tab
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		String pimTitle = driver.getTitle();
		System.out.println("PIM page title : " + pimTitle);
	}

	@Test(priority = 2)
	public void testVerifyAdmin() {
		System.out.println("Verify Admin page");
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		String adminTitle = driver.getTitle();
		System.out.println("Admin page title : " + adminTitle);
	}
}
