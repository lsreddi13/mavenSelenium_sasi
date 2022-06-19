package com.selenoum.dataDriven.ExternalFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHRM_CreatUser {

	static String url = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

//	static String user_Name = "Bheem1";
//	static String emp_Name = "John Smith";
//	static String password = "admin123";

	static WebDriver driver;

	@BeforeClass
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
	public Object[][] getCreateUserTestData() throws EncryptedDocumentException, IOException {
		return getTestData();
	}

	public void testCreateNewUser(String Role, String emp_Name, String user_Name, String status, String password,
			String c_password) throws InterruptedException {
		try {

			Thread.sleep(1000);
			driver.findElement(By.id("searchSystemUser_userName")).clear();
			driver.findElement(By.id("searchSystemUser_userName")).sendKeys(user_Name);

			driver.findElement(By.id("searchBtn")).click();
			Thread.sleep(3000);
			String val = driver.findElement(By.cssSelector("#resultTable > tbody > tr > td")).getText();

			Assert.assertEquals(val, "No Records Found", "user name exists.");

			driver.findElement(By.id("btnAdd")).click();
			Thread.sleep(1000);
			WebElement user_Role = driver.findElement(By.id("systemUser_userType"));
			Select s = new Select(user_Role);
//		s.selectByIndex(1);
			s.selectByVisibleText(Role);

			Thread.sleep(1000);
			driver.findElement(By.id("systemUser_employeeName_empName")).clear();
			driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(emp_Name);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".ac_results > ul > li > strong")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("systemUser_userName")).sendKeys(user_Name);
			Thread.sleep(1000);
			WebElement user_Status = driver.findElement(By.id("systemUser_status"));
			Select s2 = new Select(user_Status);
//		s2.selectByIndex(1);
			s2.selectByVisibleText(status);
			Thread.sleep(3000);
			driver.findElement(By.id("systemUser_password")).clear();
			driver.findElement(By.id("systemUser_password")).sendKeys(password);
			driver.findElement(By.id("systemUser_confirmPassword")).clear();
			driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(c_password);
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e);
		} finally {
//			Thread.sleep(3000);
			driver.findElement(By.id("menu_admin_viewAdminModule")).click();
			Thread.sleep(2000);
		}
	}

	@Test(dataProvider = "createUSer")
	public void test(String s1, String s2, String s3, String s4, String s5, String s6) throws InterruptedException {
		testCreateNewUser(s1, s2, s3, s4, s5, s6);
		Thread.sleep(3000);
		driver.findElement(By.id("searchSystemUser_userName")).clear();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(s3);

		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		String val2 = driver.findElement(By.cssSelector("#resultTable > tbody > tr > td:nth-of-type(2) > a")).getText();

		Assert.assertEquals(val2, s3, "user does not exists");

	}

	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
//		public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\testdataFiles\\data2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("CrateUserUser");

		System.out.println("last row noumber (row count) : " + sheet.getLastRowNum());

		System.out.println("last column number ( Column Count ) : " + sheet.getRow(0).getLastCellNum());

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) { // iterate till last row.

			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) { // iterate till last column

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		for (Object[] objects : data) {
			System.out.println(Arrays.toString(objects));
		}

		return data;
	}
}
