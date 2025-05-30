package scrollBar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadfiles {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("singleFileInput")).sendKeys("D:\\Eclipce Workspace\\TestFile\\TestData01.txt");
		driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		
		String statusmsg = driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText();
		
		if(statusmsg.contains("Single file selected: TestData01.txt")) 
		{
			System.out.println("File uploaded successfully...!");
		}
		else
		{
			System.out.println("File uploaded failed...!");
		}

	}

}
