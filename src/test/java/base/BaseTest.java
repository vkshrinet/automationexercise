package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.DriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
	private WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver = DriverFactory.getDriver("Chrome");
		driver.get("https://automationexercise.com/");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Automation Exercise"));
	}
	@AfterClass
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
