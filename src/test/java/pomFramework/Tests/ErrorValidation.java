package pomFramework.Tests;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pomFramework.TestReusableUtility.BaseTest;
import pomFramework.pageObjects.CartPage;
import pomFramework.pageObjects.HomePage;

public class ErrorValidation extends BaseTest{

	
	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {

		
		landingPage.LogIn("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		HomePage homePage = landingPage.LogIn("joyjitghosh98@gmail.com", "vpsWikFc@Dab9dB");
		List<WebElement> products = homePage.getProductList();
		homePage.addProductToCart(productName);
		CartPage cartPage = homePage.goToCart();
		Boolean match = cartPage.verifyProductsInCart(productName);
		Assert.assertTrue(match);
		
	

	}
}
