package amazon_02;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartAmazon {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to Amazon
        driver.get("https://www.amazon.in/");

        // Search for a product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 15");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Click on the first product link
        WebElement firstProduct = driver.findElement(By.cssSelector("div.s-main-slot div[data-index='1'] h2 a"));
        String parentWindow = driver.getWindowHandle();
        firstProduct.click();

        // Switch to new tab if it opened
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Wait for product page to load
        Thread.sleep(3000); // Optional, replace with explicit wait if needed

        // Click "Add to Cart"
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Confirmation
        Thread.sleep(2000); // Optional
        System.out.println("Product added to cart successfully.");

        // Close browser
        driver.quit();
    }
}

