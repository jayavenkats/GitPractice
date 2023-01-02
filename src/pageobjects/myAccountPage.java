package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class myAccountPage {

	private WebDriver driver;
	
	By logout = By.id("lbLoginOut");
	By opennewacc = By.linkText("Open New Account");
	By accstatus = By.linkText("Account Request Status");
	
	public myAccountPage (WebDriver driver2) {
		driver= driver2;
	}
	
	

	
}
