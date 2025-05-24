package Tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//count of total number of pages and using for loop click on active page
		int totalPage = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		System.out.println("Total number of pages aviliable: "+totalPage);
		
		for(int i=1; i<=totalPage; i++)
		{
			if(i>1)
			{
				WebElement active_page = driver.findElement(By.xpath("//ul[@id='pagination']//*[text()="+i+"]"));
				active_page.click();
				Thread.sleep(3000);
			}
		
		//Reading data from table first get the total number of rows	
		int tRow = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
				
		for(int r=1; r<=tRow;r++)
		{
			String pName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
			System.out.print(pName);
			WebElement pCheckbox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']"));
			pCheckbox.click(); 
		}
			System.out.println("\t");
		}
		driver.quit();
	}

}
