package pomFramework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomFramework.TestReusableUtility.BaseTest;
import pomFramework.pageObjects.CartPage;
import pomFramework.pageObjects.CheckoutPage;
import pomFramework.pageObjects.HomePage;


public class Framework1 extends BaseTest{
	
	String choice = "iphone 13 pro";
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		
		
		HomePage homePage = landingPage.LogIn("joyjitghosh98@gmail.com", "vpsWikFc@Dab9dB");
		homePage.addProductToCart(choice);
		CartPage cartPage=homePage.goToCart();
		Boolean check =cartPage.verifyProductsInCart(choice);
		Assert.assertTrue(check);
		CheckoutPage CheckoutPage = cartPage.checkOut();
		//Wait for the animation
//		//select country
//		driver.findElement(By.cssSelector(("input[placeholder = 'Select Country']"))).sendKeys("india");
//		
//		//wait for the list to appear
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.form-group section.list-group"))));
//		
//		//selecting india
//		driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();		
//		
//		//ordering
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.actions a")));
//		WebElement proceed = driver.findElement(By.cssSelector("div.actions a"));
//		js.executeScript("arguments[0].click();", proceed);
//		
//		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(msg.trim().equalsIgnoreCase("Thankyou for the order."));
//		
//		driver.close();
	}

}
