package DataDrivenTestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdwn {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		

			
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		String filepath=System.getProperty("user.dir")+"\\testData\\depositcalculatorData.xlsx";
		//count the total number of rows using excelutility file
		int rows=Excelutils.getRowCount(filepath, "Sheet1");
		
	
			//Reading data from excel

		for(int i=1; i<=rows;i++)
			
		{
			String compounding=Excelutils.getCellData(filepath, "Sheet1", i, 3);
			
		WebElement dropdown =driver.findElement(By.xpath("//mat-select[@role='combobox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropdown);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//mat-option[@role='option']"));
		
		boolean found = false;
		for (WebElement option : options) {
			if(option.getText().trim().equalsIgnoreCase(compounding.trim()))	
			{
				option.click();
				found = true;
				break;
			
		}
	}
		if (!found) 
		{
            System.out.println("Option '" + compounding + "' not found in dropdown.");
        }

        Thread.sleep(1000); 
        driver.findElement(By.xpath("//button[@type='submit']")).click();
}
}
}
