import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_Registration {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Login to Amazon
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("sachin.mehetre22@gmail.com");
		driver.findElement(By.xpath("//span[@id='continue']")).click();
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Trupti#22");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
				
		//Amazon dynamic searchBox
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung");
		Thread.sleep(3000);
		List <WebElement> searchList = driver.findElements(By.xpath("//div[@role='grid']//div[@role='button']"));
		System.out.println(searchList.size());
		
		for (int i=0; i<searchList.size(); i++)
		{
			System.out.println(searchList.get(i).getText());
			if(searchList.get(i).getText().equals("samsung s24 fe 5g"))
			{
				searchList.get(i).click();
				break;
			}
	
		}
		List <WebElement> productList = driver.findElements(By.xpath("//div[@data-cy='title-recipe']"));
		System.out.println(productList.size());
		
		

		for (WebElement product : productList) {
		    String productname = product.getText();
		    
		    if (productname.toLowerCase().contains("galaxy s25")) {
		        product.click(); // Click the product
		        break;           // Exit loop once found
		    }
		}


			
			
		}
		
		
		/*
		WebElement accList = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		Actions act = new Actions(driver);
		act.moveToElement(accList).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='nav-item-signout']")); 
		
		driver.close();
		*/
	}












