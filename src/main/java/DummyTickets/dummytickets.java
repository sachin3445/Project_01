package DummyTickets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class dummytickets {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@value='onewaymain']")).click();
		
		driver.findElement(By.xpath("//form[@id='flight_oneway']//input[@name='source[]']")).sendKeys("ADA");
		List <WebElement> drpSourceOp = driver.findElements(By.xpath("//form[@id='flight_oneway']//ul//li//div[@class='suggestion-block']"));
		System.out.println("Total number of Source Location: "+drpSourceOp.size());
		
		
		for (WebElement optionsorce : drpSourceOp) {
            String srcText = optionsorce.getText().trim();
            System.out.println("Found: " + srcText);
            if (srcText.contains("Sakirpasa Airport")) {
                new Actions(driver).moveToElement(optionsorce).click().perform();
                break;
            }
            
           if (srcText.contains("Wainwright Airport")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionsorce);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionsorce);  // Use JS click to bypass visibility issue
                break;
            }
        }
		
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		
		driver.findElement(By.xpath("//form[@id='flight_oneway']//input[@name='destination[]']")).sendKeys("BFL");
		List <WebElement> drpDestinationop=driver.findElements(By.xpath("//div[@id='onewaymain']//div[2]//ul//li"));
		System.out.println("Total number of Distini Location: "+drpDestinationop.size());
		
		for (WebElement optiondesti : drpDestinationop) {
            String DestiniText = optiondesti.getText().trim();
            System.out.println("Found: " + DestiniText);
           
            if (DestiniText.contains("Kern County-Meadows Field Airport")) {
                new Actions(driver).moveToElement(optiondesti).click().perform();
                break;
            
            }
           
        }
		Thread.sleep(5000);
		String date="10";
		
		driver.findElement(By.xpath("(//input[@placeholder='Departure Date'])[1]")).click();
		//driver.findElement(By.xpath("//input[@class='departure required mb-2 hasDatepicker']")).click();
		WebElement yearop=driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select year=new Select(yearop);
		year.selectByValue("2025");
		
		WebElement monthop=driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
		Select month=new Select(monthop);
		month.selectByValue("7");
		
		List <WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
			}
		}
	}
}
