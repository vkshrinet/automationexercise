package day24;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SixthAutomationTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String expectedTitle="Automation Exercise";
		String actualTitle=driver.getTitle();
			if(actualTitle.contains(expectedTitle))
			{
				System.out.println("Home page is visible successfull");
			}
			else
			{
				System.out.println("Home page is not visible");
			}
		driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
		boolean getInTouch=driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();
		if (getInTouch)
		{
			System.out.println("Get in touch is visible");
		}
		else
		{
			System.out.println("Get in touch is not visible");
		}
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Vivek Kumar Singh");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Subject']")).sendKeys("Enquiry");
		driver.findElement(By.cssSelector("#message")).sendKeys("This is test message");
		WebElement uploadFile=driver.findElement(By.xpath("//input[@name='upload_file']"));
		uploadFile.sendKeys("C:\\Users\\vkshr\\OneDrive\\Desktop\\Tiranga-Wallpaper-Indian-Flag.jpg");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		try {
		    Thread.sleep(2000); // 2 seconds
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		alert.accept();
		boolean successMsg=driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();
		if (successMsg)
		{
			System.out.println("Your details have been submitted successfully is visible");
		}
		else
		{
			System.out.println("Not Visible");
		}
		driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
		
		driver.quit();
	}

}
