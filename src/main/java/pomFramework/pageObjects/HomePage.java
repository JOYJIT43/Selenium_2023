  package pomFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomFramework.abstractUtilityComponents.ReusableUtility;

public class HomePage extends ReusableUtility{
	
	WebDriver driver;
    String homeUrl="https://rahulshettyacademy.com/client/dashboard/dash";
    
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		//while execution and invocation this below line is responsible for bringing the pageelements to live
		//with Driver.findelements(By.....)
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.card")
	 List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	
	By productsBy= By.cssSelector("div.card-body");
	By addToCart = By.cssSelector("button i.fa-shopping-cart");
	By toastMsg= By.className("toast-message");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productName)
	{
		//using the getProductList will actually help , like it already has a wait and then only it will come here
		 List <WebElement> list = getProductList();
		WebElement got =list.stream().filter(product -> 
		product.findElement(By.cssSelector("div h5 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return got;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement Product = getProductByName(productName);
		Product.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		

		//waitForElementToDisappear(animation);
	}

	
	//@FindBy()
	
	//method to Login
	
}
