package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			browser = browser.toLowerCase();
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			}
			else {
				throw new IllegalArgumentException("Browser not supported: "+browser);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver=null;
		}
	}

}
