package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdAutomationTest {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		boolean homePageDisplayed=driver.findElement(By.xpath("//div[@class='item active']//h1[1]")).isDisplayed();
		if (homePageDisplayed) {
			System.out.println("Home page is displayed");
		} else {
			System.out.println("Home page is not displayed");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		boolean loginAccount=driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
		if (loginAccount) {
			System.out.println("Login to your account is visible");
		} else {
			System.out.println("Login to your account is not visible");
		}
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("vs@gamil.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("vs123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		boolean incorrectEmailPass=driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).isDisplayed()
;
		if (incorrectEmailPass) {
			System.out.println("Your email or password incorrect is visible");
		} else {
			System.out.println("Your email or passowrd incorrect is not visible");
		}
	}

}
