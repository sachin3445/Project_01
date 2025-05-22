package amazon_02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class amazonFlow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement accList = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
		Actions act = new Actions(driver);
		
		act.moveToElement(accList).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
		
		// login pop up
		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("9561037803");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Sign in with Password
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Trupti#22");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		Thread.sleep(3000);
		List <WebElement> searchItems = driver.findElements(By.xpath("//div[@role='grid']//div[@role='button']"));
		System.out.println(searchItems.size());
		
		for(int i=0; i<searchItems.size(); i++)
		{
			if(searchItems.get(i).getText().equals("iphone 15 128+gb"))
			searchItems.get(i).click(); 
			
		}
		
		 
	}

}
