package Tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bootStrapTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Login to admin BO
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Click on Admin tab and navigate to admin page
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		

		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(5));
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']//div[@role='row']")));
		
		//read the data from table
		int tRow = driver.findElements(By.xpath("//div[@role='table']//div[@role='row']")).size();
		System.out.println("Total number of row with header:" +tRow);
		
		for (int i=1; i<tRow;i++)
		{ 
			String userName=driver.findElement(By.xpath("//div[@role='rowgroup']//div["+i+"]//div[1]//div[2]//div[1]")).getText();
			//System.out.print(userName);
			String userRole=driver.findElement(By.xpath("//div[@role='rowgroup']//div["+i+"]//div[1]//div[3]//div[1]")).getText();
			System.out.println("UserName: "+userName + " " +"UserRole: " + userRole);
		}
		
		
	//driver.quit();
	}
	
}
