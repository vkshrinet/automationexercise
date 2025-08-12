package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondAutomationTest {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String expectedTitle="Automation Exercise";
		String actualTitle=driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Home page is visible successfully");
		} else {
			System.out.println("Home page is not visible");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		boolean loginFormVisible=driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
		if (loginFormVisible) {
			System.out.println("Form is visible");
		} else {
			System.out.println("Form is not visible");
		}
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Vivek_9953");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		boolean nameDisplayed=driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed();
		if (nameDisplayed)
		{
			System.out.println("Account login successfully");
		} else {
			System.out.println("Account does not exist or so");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
		boolean acntDeleted=driver.findElement(By.xpath("//h2/b[text()='Account Deleted!']")).isDisplayed();
		if (acntDeleted) {
			System.out.println("Account is deleted");
		} else {
			System.out.println("Account is not deleted");
		}
	}

}
