package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FifthAutomationTest {
	@Test (priority=5)
	public void TestCase5()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
			if (actualTitle.contains(expectedTitle)) {
				System.out.println("Home page is displayed");
			} else {
				System.out.println("Home page is not displayed");
			}
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		boolean signupVisible=driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();
		if (signupVisible)
		{
			System.out.println("New user signup is visible");
		}
		else
		{
			System.out.println("Not visible");
		}
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Vivek Kumar Singh");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
		boolean emailAready=driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed();
		if (emailAready)
		{
			System.out.println("Email already exists visible");
		}
		else
		{
			System.out.println("Email already exists not visible");
		}
		driver.close();
	}

}
