package actionMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class newTabUsingClt_Click {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions act=new Actions(driver);
		driver.get("https://demo.opencart.com.gr/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		WebElement regLink =driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		Set<String> winIds =driver.getWindowHandles();
		List<String> winId=new ArrayList<String>(winIds);
		//System.out.println(winId);
		driver.switchTo().window(winId.get(1));
		String pageTitle=driver.getTitle();
		
		
		if (pageTitle.equals("Register Account"))
		{
			System.out.println("Test Case Passed...!");
		}
		else
		{
			System.out.println("Test Case Failed...!");
		}
		
		Thread.sleep(3000);
		driver.switchTo().window(winId.get(0));
	}

}
