package actionMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleclick {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement field1=driver.findElement(By.id("field1"));
		WebElement field2=driver.findElement(By.id("field2"));
		WebElement button=driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		field1.clear();
		field1.sendKeys("Hello Sachit...!");
		
		Actions act=new Actions(driver);
		act.doubleClick(button).click().perform();
		
		if(field2.getAttribute("value").equals(field1.getAttribute("value")))
		{
			System.out.println("Text coppied");
		}
		else
		{
		System.out.println("Text not coppied");
		}

	}

}
