package pomFramework.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Pre_Framework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Product to Select
		String choice = "iphone 13 pro";

		// This line will automatically pull the browser version which is device compatible 
		//WebDriverManager.chromedriver().setup();
		
		//driver adjustments
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//getting URL
		driver.get("https://rahulshettyacademy.com/client");
		
		//Enter Username and Password
		driver.findElement(By.id("userEmail")).sendKeys("joyjitghosh98@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("vpsWikFc@Dab9dB");
		
		//click on login
		driver.findElement(By.cssSelector(".login-btn")).click();		
	
		// External Wait for letting the page get loaded
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/client/dashboard/dash"));
		
		//verify whether log in is Successful
		//Assert.assertEquals("https://rahulshettyacademy.com/client/dashboard/dash", driver.getCurrentUrl());
		
		//getting all the Items in the Cart
		List<WebElement> products = driver.findElements(By.cssSelector("div.card"));
	
		//Finding the Product which we want to choose
		WebElement got=products.stream().filter(product -> 
		product.findElement(By.cssSelector("div b")).getText().equalsIgnoreCase(choice)).findFirst().orElse(null);
		
		//Selecting and Adding in Cart
		got.findElement(By.cssSelector("button i.fa-shopping-cart")).click();	
		
		//Wait for the animation
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("toast-container")),"Product Added To Cart"));
		
		//check cart
		driver.findElement(By.cssSelector("button[routerlink=\'/dashboard/cart\']")).click();
		
		//checking whether the item/items added in the cart are present or not
		
		
		List <WebElement> cartItems = driver.findElements(By.cssSelector("div.infoWrap"));
		Boolean bool = cartItems.stream().anyMatch(cartProduct->
		cartProduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(choice));
		Assert.assertTrue(bool);
		
		//checkout
		driver.findElement(By.cssSelector("li.totalRow button.btn")).click();
		
		//select country
		driver.findElement(By.cssSelector(("input[placeholder = 'Select Country']"))).sendKeys("india");
		
		//wait for the list to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.form-group section.list-group"))));
		
		//selecting india
		driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();		
		
		//ordering
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.actions a")));
		WebElement proceed = driver.findElement(By.cssSelector("div.actions a"));
		js.executeScript("arguments[0].click();", proceed);
		
		
		//verifying order has been placed
		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.trim().equalsIgnoreCase("Thankyou for the order."));
		
		//CLOSE
		driver.close();
	}

}
