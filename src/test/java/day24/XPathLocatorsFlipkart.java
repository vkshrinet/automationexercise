package day24;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathLocatorsFlipkart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Search for "mobile"
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search')]")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'_2iLD__')]")).click();

		// Wait and click the first product in the list
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'CGtC98')]")));
		firstProduct.click();

		// Switch to new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		// Click "Add to Cart"
		WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')]")));
		addToCartBtn.click();

		// Click "Place Order"
		WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Place Order']/ancestor::button")));
		placeOrderBtn.click();

		// You will now be redirected to the login page
		System.out.println("Test completed: Product added and order placed till login page.");
	}
}

