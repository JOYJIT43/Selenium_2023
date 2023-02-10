package pomFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomFramework.abstractUtilityComponents.ReusableUtility;

public class CheckoutPage extends ReusableUtility{

	public WebDriver driver;    

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder = 'Select Country']")
	WebElement selectCountry;
	
	@FindBy(css="div.actions a")
	WebElement placeOrderBtn;
	
	@FindBy(css="button.list-group-item")
	List<WebElement> countries;
	
	public void selectCountry(String name)
	{
		selectCountry.sendKeys(name);
		waitForElementToAppear(By.cssSelector("div.form-group section.list-group"));
	    countries.stream().filter(country ->
	    country.findElement(By.cssSelector("span.ng-star-inserted")).getText().equalsIgnoreCase(name)).forEach(country -> country.click());
       
	}
	
    public ConfirmationPage placeOrder()
    {
    	 waitForElementToBeClickable(placeOrderBtn);
    	 placeOrderBtn.click();
		 return new ConfirmationPage(driver);
    }
}
//		WebElement proceed = driver.findElement(By.cssSelector("div.actions a"));
//		js.executeScript("arguments[0].click();", proceed);
//		

	//wait for the list to appear

