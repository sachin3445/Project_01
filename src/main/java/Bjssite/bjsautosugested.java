package Bjssite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bjsautosugested {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.manage().window().maximize();
	driver.get("https://www.bjs.com");
	
	driver.findElement(By.xpath("//input[@placeholder='What are you looking for today?']")).sendKeys("milk");
	Thread.sleep(3000);
	WebElement drpOption=(WebElement) driver.findElements(By.xpath("//div[@role='listbox']//a[@data-link-type='inline']"));
	System.out.println(drpOption.getSize()); 

	}

}
