package makeMyTrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firstflow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Mobile Number']")));
	    mobileInput.sendKeys("9561037803");

	    // Wait for the Continue button and click it
	    WebElement btn_Continue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Continue']")));
	    btn_Continue.click();
		
		
	/*	driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("9561037803");
		Thread.sleep(3000);
		WebElement btn_Continue = driver.findElement(By.xpath("//span[normalize-space()='Continue']"));
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(btn_Continue));
		*/
		//btn_Continue.sendKeys(Keys.ENTER);
		
		//Actions act = new Actions(driver);
		//act.moveToElement(btn_Continue).click().perform();

	}

}
