package DataDrivenTestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		//Browse the excel file from location to read the data
		String filepath=System.getProperty("user.dir")+"\\testData\\depositcalculatorData.xlsx";
		//count the total number of rows using excelutility file
		int rows=Excelutils.getRowCount(filepath, "Sheet1");
		
		for(int i=1; i<=rows;i++)
		{
			//Reading data from excel
			String initialDeposit=Excelutils.getCellData(filepath, "Sheet1", i, 0);
			String lengthDC=Excelutils.getCellData(filepath, "Sheet1", i, 1);
			String roi=Excelutils.getCellData(filepath, "Sheet1", i, 2);
			String compounding=Excelutils.getCellData(filepath, "Sheet1", i, 3);
			String totalCD=Excelutils.getCellData(filepath, "Sheet1", i, 4);
			
			//Assign data to field
			WebElement initDepositAmt=driver.findElement(By.xpath("//input[@formcontrolname='cdAmount']"));
			initDepositAmt.clear();
			initDepositAmt.sendKeys(initialDeposit);
			
			WebElement lengthofDC=driver.findElement(By.xpath("//input[@formcontrolname='cdLength']"));
			lengthofDC.clear();
			lengthofDC.sendKeys(lengthDC);
			
			WebElement intrestRate=driver.findElement(By.xpath("//input[@formcontrolname='cdRate']"));
			intrestRate.clear();
			intrestRate.sendKeys(roi);
		
			WebElement dropdown= driver.findElement(By.xpath("//mat-select[@role='combobox']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", dropdown);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//mat-option")));
			List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//mat-option[@role='option']"));
			
			boolean found = false;
			for (WebElement option : options) 
			{
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

			//Validation
				String act_totalValue= driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
				String total=act_totalValue.replace("$", "").replace(",", "").trim();
				System.out.println(total);
				if (Double.parseDouble(total)==Double.parseDouble(totalCD) )
				{
					System.out.println("Test Pass..!");
					Excelutils.setCellData(filepath, "Sheet1", i, 6, "Passed");
					Excelutils.setGreencolor(filepath, "Sheet1", i, 6);
				}
				else
				{
					System.out.println("Test Failed..!");
					Excelutils.setCellData(filepath, "Sheet1", i, 6, "Failed");
					Excelutils.setRedcolor(filepath, "Sheet1", i, 6);
				}
			
			}
			
			Thread.sleep(3000);
		}

	}

