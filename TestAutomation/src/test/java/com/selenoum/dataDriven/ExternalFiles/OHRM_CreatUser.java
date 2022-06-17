package com.selenoum.dataDriven.ExternalFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHRM_CreatUser {

	static String url = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	static String user_Name = "Bheem1";
	static String emp_Name = "John Smith";
	static String password = "admin123";

	static WebDriver driver;

	@BeforeMethod
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(url);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		WebElement pwd = driver.findElement(By.id("txtPassword"));
		pwd.sendKeys("admin123");
		pwd.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	@DataProvider(name = "createUSer")
	public Object[][] getCreateUserTestData() {

		return new Object[][] { { "Admin", "peter", "Enabled", "Ramesh", "ramesh123", "ramesh123" }, // first row
				{ "ESS", "daniel", "Enabled", "Vikram", "vikram123", "vikram123" }, // second row
				
		};
	}

	@Test(dataProvider = "createUSer")
	public void test() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(user_Name);

		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		String val = driver.findElement(By.cssSelector("#resultTable > tbody > tr > td")).getText();

		Assert.assertEquals(val, "No Records Found", "user name exists.");

		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(3000);
		WebElement user_Role = driver.findElement(By.id("systemUser_userType"));
		Select s = new Select(user_Role);
		s.selectByIndex(1);
				
		Thread.sleep(3000);
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(emp_Name);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ac_results > ul > li > strong")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("systemUser_userName")).sendKeys(user_Name);
		Thread.sleep(3000);
		WebElement user_Status = driver.findElement(By.id("systemUser_status"));
		Select s2 = new Select(user_Status);
		s2.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.id("systemUser_password")).sendKeys(password);

		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);

		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(user_Name);

		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		String val2 = driver.findElement(By.cssSelector("#resultTable > tbody > tr > td:nth-of-type(2) > a")).getText();

		Assert.assertEquals(val2, user_Name, "user does not exists");

	}
}
