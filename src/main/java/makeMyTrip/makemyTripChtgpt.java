package makeMyTrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class makemyTripChtgpt {

	public static void main(String[] args) {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.get("https://www.makemytrip.com/");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Close overlay/popup
	    try {
	        WebElement popupClose = driver.findElement(By.cssSelector(".loginModal .modalClose"));
	        popupClose.click();
	    } catch (Exception e) {
	        System.out.println("No popup found");
	    }

	    // Enter mobile number
	    WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Mobile Number']")));
	    mobileInput.sendKeys("9561037803");

	    // Wait and click using JavaScriptExecutor
	    WebElement btn_Continue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Continue']/parent::button")));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", btn_Continue);
	}
	
}


