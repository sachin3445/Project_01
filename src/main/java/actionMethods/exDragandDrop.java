package actionMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class exDragandDrop {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		WebElement bank=driver.findElement(By.xpath("//li[@id='credit2']"));
		WebElement addAmount=driver.findElement(By.xpath("//li[@data-id='2']"));
		WebElement sales=driver.findElement(By.xpath("//li[@id='credit1']"));
		WebElement debitAmount=driver.findElement(By.xpath("//li[@id='credit0']"));
		
		//Debit side
		WebElement drAcc=driver.findElement(By.xpath("//ol[@id='bank']"));
		WebElement drAmount=driver.findElement(By.xpath("//ol[@id='amt7']"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(bank, drAcc).perform();
		act.dragAndDrop(addAmount, drAmount).perform();
		
		//Credit Side
		WebElement crAcc=driver.findElement(By.xpath("//ol[@id='loan']"));
		act.dragAndDrop(sales, crAcc).perform();
		act.dragAndDrop(debitAmount, addAmount).perform();

	}

}
