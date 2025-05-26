package DummyTickets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dummytickets {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@value='onewaymain']")).click();
		
		driver.findElement(By.xpath("//form[@id='flight_oneway']//input[@name='source[]']")).sendKeys("as");
		List <WebElement> drpSourceOp = driver.findElements(By.xpath("//form[@id='flight_oneway']//ul//li//div[@class='suggestion-block']"));
		System.out.println(drpSourceOp.size());
		
		
		for (WebElement optionsorce : drpSourceOp) {
            String text = optionsorce.getText().trim();
            System.out.println("Found: " + text);
            if (text.contains("Almassira Airport")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionsorce);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionsorce);  // Use JS click to bypass visibility issue
                break;
            }
        }
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='flight_oneway']//input[@name='destination[]']")).sendKeys("was");
		List <WebElement> drpDestinationop=driver.findElements(By.xpath("//div[@id='onewaymain']//div[2]//ul//li"));
		System.out.println(drpDestinationop.size());
		Thread.sleep(5000);
		for (WebElement optiondesti : drpDestinationop) {
            String text = optiondesti.getText().trim();
            System.out.println("Found: " + text);
           /* if (text.contains("Al Gaidah Airport")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optiondesti);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optiondesti);  // Use JS click to bypass visibility issue
                break;
            } */
        }
	}

}
