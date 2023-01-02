package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseClass {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void browserInitiation(String browser, String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jars\\chromedriver 102\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	@Parameters({"browser", "url"})
	
	public void setUp(String browsername,String url1) {
		browserInitiation(browsername, url1);
	}
	 @AfterTest
	  public void tearDown() {
		 driver.quit();		 
	 }
}


