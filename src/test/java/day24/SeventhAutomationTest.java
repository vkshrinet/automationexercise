package day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeventhAutomationTest {
	public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://automationexercise.com");
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleIs("Automation Exercise"));
	String expectedTitle="Automation Exercise";
	String actualTitle=driver.getTitle();
	if (actualTitle.contains(expectedTitle)) {
		System.out.println("Home page is visible");
	} else {
		System.out.println("Home page is not visible");
	}
	driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
	boolean testCaseVerified=driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).isDisplayed();
	if (testCaseVerified) {
		System.out.println("Test case is visible");
	} else {
		System.out.println("Test case is not visible");
	}
	driver.quit();
	
	}

}
