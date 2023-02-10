package pomFramework.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomFramework.TestReusableUtility.BaseTest;
import pomFramework.pageObjects.CartPage;
import pomFramework.pageObjects.CheckoutPage;
import pomFramework.pageObjects.ConfirmationPage;
import pomFramework.pageObjects.HomePage;


public class Framework1 extends BaseTest{
	
	
	@Test(dataProvider="readData")
	public void submitOrder(HashMap <String,String> input) throws IOException, InterruptedException {
		
		
		HomePage homePage = landingPage.LogIn(input.get("email"), input.get("password"));
		homePage.addProductToCart(input.get("product"));
		CartPage cartPage=homePage.goToCart();
		Boolean check =cartPage.verifyProductsInCart(input.get("product"));
		
		Assert.assertTrue(check);
		
		CheckoutPage CheckoutPage = cartPage.checkOut();
		CheckoutPage.selectCountry(input.get("country"));
		ConfirmationPage confirmationPage= CheckoutPage.placeOrder();
		
		Assert.assertEquals(confirmationPage.getSuccessMsg(),"THANKYOU FOR THE ORDER.");
	}
	
	
	@DataProvider
	public void readData()
	{
		
	}

}
