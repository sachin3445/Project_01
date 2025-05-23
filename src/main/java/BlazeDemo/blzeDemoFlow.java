package BlazeDemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class blzeDemoFlow {


	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement drpfromPort=driver.findElement(By.name("fromPort"));
		Select selectopfromPort=new Select(drpfromPort);
		selectopfromPort.selectByValue("Paris");
		
		WebElement drotoPort=driver.findElement(By.name("toPort"));
		Select selectdrpoptoPort=new Select(drotoPort);
		selectdrpoptoPort.selectByValue("London");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// get the total number of flights
			
		int tRow=driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		int tCol=driver.findElements(By.xpath("//table[@class='table']//tr[1]//td")).size();
		System.out.println("Total number of Row & Column are: " +tRow + " " +tCol);
		
		//get the price from table
		
		List<Double> prices = new ArrayList<>();
		 
		for(int i=1; i<tRow; i++)
		{
			WebElement priceValues=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]"));
			String priceText = priceValues.getText().replace("$", "").trim();
			double price = Double.parseDouble(priceText);
			prices.add(price);
		}
		
		System.out.print(prices);	
		
		double minPrice = prices.get(0);
        int minIndex = 0;

        for (int i = 1; i < prices.size(); i++) 
        {
            if (prices.get(i) < minPrice) 
            {
                minPrice = prices.get(i);
                minIndex = i;
            }
        }
        System.out.println("minIndex: " +minIndex);
        
        System.out.println("Cheapest flight price: $" + minPrice);  
        Thread.sleep(3000);
        WebElement cheapestFlightButton=driver.findElement(By.xpath("//table[@class='table']//tr[1]//td[1]//input[@type='submit']"));
        //WebElement cheapestFlightButton = rows.get(minIndex).findElement(By.xpath("td[1]///input[@type='submit']"));
        cheapestFlightButton.click();
        
        //Fill the form
        driver.findElement(By.id("inputName")).sendKeys("Sachin Mehetre");
        driver.findElement(By.id("address")).sendKeys("Flat 301 Harmaony Pimple-Gurav");
        driver.findElement(By.id("city")).sendKeys("Pune");
        driver.findElement(By.id("state")).sendKeys("Maharastra");
        driver.findElement(By.id("zipCode")).sendKeys("431517");
        WebElement cardType=driver.findElement(By.id("cardType"));
        Select ccTypeop=new Select(cardType); 
        ccTypeop.selectByValue("amex");
        driver.findElement(By.id("creditCardNumber")).sendKeys("1425236574781236");
        driver.findElement(By.id("creditCardMonth")).sendKeys("10");
        driver.findElement(By.id("creditCardYear")).sendKeys("2027");
        driver.findElement(By.id("nameOnCard")).sendKeys("Sachin Sachin");
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        
        boolean successmsg = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed();
       
        if (successmsg ==true )
        {
        	System.out.println("This test case completed successfuly...!");
        }
        
      
        //driver.quit();
	}
		
}
