package pomFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomFramework.abstractUtilityComponents.ReusableUtility;

public class CartPage extends ReusableUtility{

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
    @FindBy(css="div.infoWrap")
    List<WebElement> cartProducts;
    
    @FindBy(css="li.totalRow button.btn")
    WebElement checkOutBtn;
    
    public Boolean verifyProductsInCart(String choice)
    {
    	Boolean bool=cartProducts.stream().anyMatch(cartProduct->
    	cartProduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(choice));
    	return bool;
    }
     public CheckoutPage checkOut()
     {
    	 checkOutBtn.click();
    	 CheckoutPage checkoutPage = new CheckoutPage(driver);
    	 return checkoutPage;
     }
    
	
}
