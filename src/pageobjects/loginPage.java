package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setup.baseClass;

public class loginPage {
	
	private WebDriver driver;
	
	By userid = By.id("body_txtUserID");
	By passwd = By.id("body_txtPassword");
	By loginbtn = By.id("body_btnLogin");
	By signup = By.id("body_lbtSignUp");
	By frgtpwd = By.id("body_lbtForgotPassword");
	
	public loginPage(WebDriver driver2) {
		driver = driver2;
	}
	
	public  myAccountPage signin (String username, String password) {
		
		myAccountPage d1=null;
		driver.findElement(userid).sendKeys(username);
		driver.findElement(passwd).sendKeys(password);
		driver.findElement(loginbtn).click();
		d1 = new myAccountPage(driver);
		return d1;
	}
}
