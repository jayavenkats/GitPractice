package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.loginPage;
import pageobjects.myAccountPage;
import setup.baseClass;

public class loginPageTest extends baseClass {
	
	WebDriver driver;
	String url = "http://10.82.180.36/Common/Login.aspx";
	
	
		@BeforeTest
		public void setup() {
			driver= getDriver();
			
		}
	
	@Test
	public void loginpgScrsht() throws IOException {
		loginPage lgn = new loginPage(driver);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\loginpage.jpg"));
				
	}
		
	@Test
	public void signUplink() throws IOException {
		
		loginPage lgn1 = new loginPage(driver);
		driver.findElement(By.id("body_lbtSignUp")).click();
		String regscreen = driver.findElement(By.id("body_divHeader")).getText();
		Assert.assertEquals(regscreen, "REGISTER WITH IN ESSENCE BANK");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\registerpage.jpg"));
			
	}
	
	@Test
	public void forgotPasswd() throws IOException {
		loginPage lgn2 = new loginPage(driver);
		driver.findElement(By.id("body_lbtForgotPassword")).click();
		String fgtpwd = driver.findElement(By.id("body_header_divHeader")).getText();
		Assert.assertEquals(fgtpwd, "FORGOT PASSWORD/UNLOCK ACCOUNT");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\frgtpswd.jpg"));
			
		
	}
	@Test
	public void login() {
	loginPage lgn3 = new loginPage(driver);
	myAccountPage lg = lgn3.signin("mercury", "mercury1!");
	String wlcmsg = driver.findElement(By.tagName(" Welcome mercury")).getText();
	Assert.assertTrue(wlcmsg.contains("Welcome"));
	
	}
	@Test
	public void logout() {
	loginPage lgn3 = new loginPage(driver);
	myAccountPage lg = lgn3.signin("mercury", "mercury1!");
	String wlcmsg = driver.findElement(By.tagName(" Welcome mercury")).getText();
	Assert.assertTrue(wlcmsg.contains("Welcome"));
	driver.findElement(By.id("lbLoginOut")).click();
	
	
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
