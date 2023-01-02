package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.loginPage;
import pageobjects.myAccountPage;
import setup.baseClass;

public class myAccountTest extends baseClass {

	WebDriver driver;
	@BeforeClass
	public void setUp () {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void openAccount() throws IOException{
	
		loginPage lgn3 = new loginPage(driver);
		myAccountPage lg = lgn3.signin("mercury", "mercury1!");
		String wlcmsg = driver.findElement(By.tagName(" Welcome mercury")).getText();
		Assert.assertTrue(wlcmsg.contains("Welcome"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\accntopening.jpg"));
			
		driver.findElement(By.linkText("Open New Account")).click();
		Select accsel = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlAccountType")));
		accsel.selectByValue("1");
		Select stsel = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlState")));
		stsel.deselectByVisibleText("Karnataka");
		Select ctsel = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlCity")));
		ctsel.deselectByValue("25");
		Select brnsel = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlBranch")));
		brnsel.selectByValue("2");
		driver.findElement(By.id("body_cph_MyAccount_fupUpload")).sendKeys("D:\\Workspace\\FT_Capstone1and3_176223\\Upload.zip");
		driver.findElement(By.id("body_cph_MyAccount_btnUpdate")).click();
		String successmsg= driver.findElement(By.id("body_cph_MyAccount_lblUpdate")).getText();
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\successmsg.jpg"));
			
			}
	@Test
	public void accountRqStatus() throws IOException {
		loginPage lgn3 = new loginPage(driver);
		myAccountPage lg = lgn3.signin("mercury", "mercury1!");
		String wlcmsg = driver.findElement(By.tagName(" Welcome mercury")).getText();
		Assert.assertTrue(wlcmsg.contains("Welcome"));
		driver.findElement(By.linkText("Account Request Status")).click();
		String stsmsg = driver.findElement(By.id("Account Request Status")).getText();
		Assert.assertTrue(stsmsg.contains("Status"));
		String ststyp = driver.findElement(By.id("body_cph_MyAccount_ddlStatusType")).getText();
		Assert.assertEquals(ststyp, "--All--");
		System.out.println("this is for git");
		System.out.println("this is git new change");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Workspace\\FT_Capstone1and3_176223\\Screenshots\\loginpage.jpg"));
			
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
