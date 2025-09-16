package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebtablePractice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://cosmocode.io/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean logoDisplay=driver.findElement(
				By.xpath("//a[contains(text(),'CosmoCode (Formerly TeachMeSelenium)')]")).isDisplayed();
		if (logoDisplay) {System.out.println("Logo Verified"); } else { System.out.println("Logo Not Verified");}
		WebElement moreMenu=driver.findElement(By.xpath("//div[@class='inside-navigation']//a[@class='mega-menu-link'][normalize-space()='More']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(moreMenu).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement webTableLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='inside-navigation']//a[@class='mega-menu-link'][normalize-space()='Automation Practice | WebTable']")));
		webTableLink.click();
		System.out.println("Page Title: "+ driver.getTitle());
		try {
		    List<WebElement> popup = driver.findElements(By.xpath("//div[@id='ad_position_box']//div[@id='dismiss-button']"));
		    if (!popup.isEmpty()) {
		        popup.get(0).click();  // Close the popup
		        System.out.println("Popup closed successfully");
		    } else {
		        System.out.println("No popup appeared");
		    }
		} catch (Exception e) {
		    System.out.println("No popup found or already closed");
		}
		boolean country=driver.findElement(By.xpath("//td[strong[normalize-space()='Albania']]/following-sibling::td[2][normalize-space()='Lek']")).isDisplayed();
		if(country) {
			System.out.println("Find the country");
		} else {
			System.out.println("Not find");
		}
		String currency=driver.findElement(By.xpath("//td[strong[(text()='Albania')]]/following-sibling::td[2]")).getText();
		System.out.println("Albania Curreny is: "+ currency);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (int i = 1; i <= rows.size(); i++) {
		    String countries = driver.findElement(
		        By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText();
		    
		    String capital = driver.findElement(
			        By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText();

		    String currencies = driver.findElement(
		        By.xpath("//table/tbody/tr[" + i + "]/td[4]")).getText();

		    System.out.println(countries + " || " + capital + " || " + currencies);
		}
		//driver.quit();
	}

}
