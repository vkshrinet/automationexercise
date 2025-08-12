package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthAutomationTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		boolean homepageDisplayed=driver.findElement(By.xpath("//div[@class='item active']//h1[1]")).isDisplayed();
		if (homepageDisplayed)
		{
			System.out.println("home page is visible successfully");
		}
		else
		{
			System.out.println("home page is not visible");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		boolean loginAccount=driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
		if (loginAccount)
		{
			System.out.println("Login page is displayed");
		}
		else
		{
			System.out.println("Login page is not displayed");
		}
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Vivek_9953");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		boolean logginVisible=driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed();
		if (logginVisible)
		{
			System.out.println("Logged in as username is visible");
		}
		else
		{
			System.out.println("Logged in as username is not visible");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		boolean loginAccounts=driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
		if (loginAccounts)
		{
			System.out.println("Login page is displayed");
		}
		else
		{
			System.out.println("Login page is not displayed");
		}
	}

}
