package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocators {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		// Xpath with the single attribute
		//driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("T-shirt");
		
		// Xpath with the multiple attribute
		//driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More'][@name='q']")).sendKeys("T-shirt");
		
		// Xpath with 'and' operator
		//driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More' and @name='q']")).sendKeys("Phone");
		
		// Xpath with 'or' operator
		//driver.findElement(By.xpath("//input[@placeholder='xyz' or @name='q']")).sendKeys("Phone");
		
		// Xpath with text() inner text
		//driver.findElement(By.xpath("//*[text()='Mobiles & Tablets']")).click();
		
		// Xpath with inner text
		/*boolean displaystatus=driver.findElement(By.xpath("//div[text()='Best of Electronics']")).isDisplayed();
		System.out.println(displaystatus);
		String value=driver.findElement(By.xpath("//div[text()='Best of Electronics']")).getText();
		System.out.println(value);*/
		
		// Xpath with contains ()
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("mobile");
		
		// Xpath with starts-with
		/*driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search')]")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'_2iLD__')]")).click();
		driver.findElement(By.xpath("//*[contains(@class, 'CGtC98')]")).click();*/
		
		// Chained xpath
		boolean imagestatus=driver.findElement(By.xpath("//div[@class='_16ZfEv']/a/picture/img")).isDisplayed();
		System.out.println(imagestatus);
	}

}
