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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("https://www.bjs.com");
	
	driver.findElement(By.xpath("//input[@placeholder='What are you looking for today?']")).sendKeys("milk");
	//WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(5));
	//List <WebElement> drpOption = myWait.until(ExpectedConditions.visibilityOfAllElements("//div[@role='listbox']//a[@auto-data='searchBar_searchRedirectedPage']"));
	//List<WebElement> drpOption = myWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//div//a[@auto-data='searchBar_searchRedirectedPage']")));
	Thread.sleep(8000);
	List <WebElement> drpOption=driver.findElements(By.xpath("//div[@role='listbox']//div[@data-cnstrc-item-section='Search Suggestions']"));
	System.out.println(drpOption.size()); 

	}

}
