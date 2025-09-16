package day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NinthAutomationTest {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		String ExpectedTitle="Automation Exercise";
		String ActualTitle=driver.getTitle();
		if (ExpectedTitle.equals(ActualTitle)) {
			System.out.println("Home page is visible successfully");
		}
		else {
			System.out.println("Home page is not visible");
		}
		driver.findElement(By.xpath("//li[a[contains(text(),'Home')]]/following-sibling::li[1]/a")).click();
		boolean productDisplay=driver.findElement(By.xpath("//div[@id='cartModal']/preceding-sibling::h2[1]")).isDisplayed();
		if(productDisplay) {
			System.out.println("All product is visibel successfully");
		} else {
			System.out.println("Not visible");
		}
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Sleeveless Dress");
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		boolean dress=driver.findElement(By.xpath("//p[normalize-space(text())='Sleeveless Dress']")).isDisplayed();
		if (dress) {
			System.out.println("Product is visible");
		} else {
			System.out.println("Product is not visible");
		}
		
	}

}
