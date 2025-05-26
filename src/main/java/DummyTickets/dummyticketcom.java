package DummyTickets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dummyticketcom {
	
	static void calanderDate(WebDriver driver, String year, String month, String date)
	{
		WebElement yearDrp = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearOp = new Select(yearDrp);
		yearOp.selectByValue(String.valueOf(year));
				
		WebElement monthDrp =driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthOp=new Select(monthDrp);
		monthOp.selectByValue(String.valueOf(month));
		
		List <WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
			}
		}
	}

	
		public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		//select order
		driver.findElement(By.xpath("//input[@id='product_549']")).click();
		
		//Passenger details
		driver.findElement(By.name("travname")).sendKeys("Trupti Sachin");
		driver.findElement(By.id("travlastname")).sendKeys("Mehetre");
		driver.findElement(By.id("order_comments")).sendKeys("Put more order information");
		
		//Passenger dob
		String dobYear="1997";
		String dobMonth="6";
		String dobDate="17";
		driver.findElement(By.id("dob")).click();
		calanderDate(driver, dobYear,dobMonth,dobDate);
	
		driver.findElement(By.id("sex_2")).click(); //Female
		
		//Travel Details
		WebElement tripType=driver.findElement(By.id("traveltype_1"));
		tripType.click();
		driver.findElement(By.id("fromcity")).sendKeys("Pune");
		driver.findElement(By.id("tocity")).sendKeys("Delhi");
		
		//Traveling Date
		String trvlYear="2025";
		String trvlMonth="7";
		String trvlDate="10";
		driver.findElement(By.id("departon")).click();
		calanderDate(driver, trvlYear,trvlMonth,trvlDate);
		
		driver.findElement(By.id("notes")).sendKeys("Need window Seat");
		
		WebElement reasondrp=driver.findElement(By.xpath("//select[@id='reasondummy']"));
		Select reasonTravel=new Select(reasondrp);
		reasonTravel.selectByContainsVisibleText("Expedite passport renewal");
		
		//Receive dummy ticket
		driver.findElement(By.id("deliverymethod_3")).click();
		
		//Billing Details
		driver.findElement(By.id("billname")).sendKeys("Sachin Mehetre");
		driver.findElement(By.id("billing_phone")).sendKeys("8899747572");
		driver.findElement(By.id("billing_email")).sendKeys("sachin.mehetre@gmail.com");
		
		WebElement billCountryOp = driver.findElement(By.id("billing_country"));
		Select billCountry=new Select(billCountryOp);
		billCountry.selectByVisibleText("Australia");
		
		driver.findElement(By.id("billing_address_1")).sendKeys("FlatNo: 301, Harmony");
		driver.findElement(By.id("billing_address_2")).sendKeys("Jagtap Damodar Path, Pimple-Gurav");
		driver.findElement(By.id("billing_city")).sendKeys("Pune");
		
		WebElement billStateOp = driver.findElement(By.id("billing_state"));
		Select billState=new Select(billStateOp);
		billState.selectByVisibleText("Victoria");
		
		driver.findElement(By.id("billing_postcode")).sendKeys("411061");
		driver.findElement(By.id("place_order")).click();
		
	}
}

