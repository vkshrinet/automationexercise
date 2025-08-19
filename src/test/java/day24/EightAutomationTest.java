package day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EightAutomationTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		String expectedTitle= "Automation Exercise";
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Home page is visible");
		} else {
			System.out.println("Home page is not visible");
		}
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		WebDriverWait waitone=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = waitone.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='All Products']")));

		// Verify if displayed
		if (element.isDisplayed()) {
		    System.out.println("All Products is visible");
		} else {
		    System.out.println("All Products is not visible");
		}
		driver.findElement(By.xpath("//div[@id='accordian']")).isDisplayed();
		driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
		WebDriverWait waittwo = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the product info section
		WebElement productDetails = waittwo.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//div[@class='product-information']")));

		// Verify individual details (labels) and capture their dynamic values
		String productName = productDetails.findElement(By.cssSelector("div[class='product-information'] h2")).getText();
		String category = productDetails.findElement(By.xpath(".//p[contains(normalize-space(.),'Category')]")).getText();
		String price = productDetails.findElement(By.cssSelector("div[class='product-information'] span span")).getText();
		String availability = productDetails.findElement(By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > p:nth-child(6)")).getText();
		String condition = productDetails.findElement(By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > p:nth-child(7)")).getText();
		String brand = productDetails.findElement(By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > p:nth-child(8)")).getText();

		// Print details for confirmation
		System.out.println("Product Name: " + productName);
		System.out.println(category);
		System.out.println("Price: " + price);
		System.out.println(availability);
		System.out.println(condition);
		System.out.println(brand);
		driver.quit();

	}

}
