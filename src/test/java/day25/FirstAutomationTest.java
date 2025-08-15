package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FirstAutomationTest {
	@Test(priority=1)
	public void TestCase1() {
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
	driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	boolean loginFormVisible=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		if (loginFormVisible) {
			System.out.println("New user signup is displayed successfully");
		} else {
			System.out.println("New user signup is not displayed");	
	    }
		driver.findElement(By.xpath("//input[@placeholder='Name' or @name='name']")).sendKeys("Vivek Kumar Singh");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("vkshrinet@gmail.com");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		// Wait briefly to allow page to load (simple wait )
        try {
            Thread.sleep(2000);  // 2 second wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     boolean signupFormVisible=driver.findElement(By.xpath("//h2/b[text()='Enter Account Information']")).isDisplayed();
     	if (signupFormVisible) {
     		System.out.println("Signup Form is displayed successfully");
     	} else {
     		System.out.println("Signup form is not displayed");
     	}
     driver.findElement(By.xpath("//input[@type='radio' and @value='Mr']")).click();
     driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("Vivek_9953");
     Select day = new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
     day.selectByValue("10");
     Select month = new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
     month.selectByVisibleText("July");
     Select year = new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));
     year.selectByValue("1987");
     driver.findElement(By.xpath("//input[@type='checkbox' and @id='newsletter']")).click();
     driver.findElement(By.xpath("//input[@type='checkbox' and @id='optin']")).click();
     driver.findElement(By.xpath("//input[@data-qa='first_name' or @id='first_name']")).sendKeys("Vivek");
     driver.findElement(By.xpath("//input[@data-qa='last_name' or @id='last_name']")).sendKeys("Singh");
     driver.findElement(By.xpath("//input[@data-qa='company' or @id='company']")).sendKeys("XYZ");
     driver.findElement(By.xpath("//input[@data-qa='address' or @id='address1']")).sendKeys("flat no 10a, Block 12, sector 135");
     driver.findElement(By.xpath("//input[@data-qa='address2' or @id='address2']")).sendKeys("Noida, pin-201301");
     Select country = new Select(driver.findElement(By.xpath("//select[@data-qa='country']")));
     country.selectByVisibleText("India");
     driver.findElement(By.xpath("//input[@data-qa='state' or @id='state']")).sendKeys("Uttar Pradesh");
     driver.findElement(By.xpath("//input[@data-qa='city' or @id='city']")).sendKeys("Noida");
     driver.findElement(By.xpath("//input[@data-qa='zipcode' or @id='zipcode']")).sendKeys("201301");
     driver.findElement(By.xpath("//input[@data-qa='mobile_number' or @id='mobile_number']")).sendKeys("9953461815");
     driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
     boolean AccountCreated=driver.findElement(By.xpath("//h2/b[text()='Account Created!']")).isDisplayed();
	  	if (AccountCreated) {
	  		System.out.println("Account Created is displayed successfully");
	  	} else {
	  		System.out.println("Account Created is not displayed");
	  	}
	 driver.findElement(By.xpath("//a[text()='Continue']")).click();
	 boolean NameDisplayed=driver.findElement(By.xpath("//li/a[contains(text(), 'Logged in as')]/b[text()='Vivek Kumar Singh']")).isDisplayed();
	 	if(NameDisplayed) {
	 		System.out.println("Name is displayed");
	 	} else {
	 		System.out.println("Name is not displayed");
	 	}
	 	try {
            Thread.sleep(5000);  // 5 second wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	 /*driver.findElement(By.xpath("//li/a[contains(., ' Delete Account')]")).click();
	 boolean accountDeleted=driver.findElement(By..xpath("//h2/b[text()='Account Deleted!']")).isDisplayed();
	 	if(accountDeleted) {
	 		System.out.println("Account Deleted is displayed");
	 	} else {
	 		System.out.println("Account Deleted is not displayed");
	 	}*/
	 driver.close();
	}
	

	
}
