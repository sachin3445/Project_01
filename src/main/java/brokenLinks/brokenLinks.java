package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. find all links
2. Find the href values empty or null
3. Check the status code>=400
4. get the all broken links 


*/
public class brokenLinks {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links: "+allLinks.size());
		
		//using for loop get href values for each link
	
			int totalnumber=0;
			try {
			for(WebElement link:allLinks)
			{
				@SuppressWarnings({ "deprecation" })
				String hrefvalue=link.getAttribute("href");
				if ( hrefvalue==null || hrefvalue.isEmpty())
				{
				System.out.println("This link hrefvalue is empty or null, so not possible to open");
				continue;
				}
		
				//convert  href value string to url to get click
				@SuppressWarnings("deprecation")
				URL elmentLink=new URL(hrefvalue);
				//open connection for server 
				HttpURLConnection openLink= (HttpURLConnection) elmentLink.openConnection();
				openLink.connect();
			
					if(openLink.getResponseCode()>=400)
					{
						System.out.println(hrefvalue + " ===>" + "This is Broken link");
						totalnumber++;
					}
			
			else
			{
				System.out.println(hrefvalue + " ===>" + "This is not broken link" );
			}
		}
	}
			catch(Exception e)
			{
				
			}
	
		System.out.println("Total number of broken links: "+totalnumber);

		}	
	}



