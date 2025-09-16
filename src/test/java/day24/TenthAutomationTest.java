package day24;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenthAutomationTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				System.out.println("Home page is displayed");
			} else {
				System.out.println("Home page is not displayed");
			}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		if (element.isDisplayed()) {
			System.out.println("Subscription is displayed");
		} else {
			System.out.println("Not display subscription");
		}
		driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.xpath("//button[@id='subscribe']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[contains(text(),'You have been successfully subscribed!')]")
		    )
		);
		if (element1.isDisplayed()) {
			System.out.println("Email subscribed");
		} else {
			System.out.println("Email not subscribed");
		}
		driver.quit();
	}

}
