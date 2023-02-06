package pomFramework.abstractUtilityComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomFramework.pageObjects.CartPage;

public class ReusableUtility {

	WebDriver driver;
	WebDriverWait wait;
		 
	public ReusableUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	   // WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
	}
	
	@FindBy(css="button[routerlink*=cart]")
	WebElement cartBtn;

	public void waitForElementToAppear(By locator) {
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public void waitForElementToDisappear(By locator)
	{
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	
	public void waitForURL(String Url)
	{
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.urlToBe(Url));
	}
	
	//TOP NAV 
	public CartPage goToCart()
	{
		
		cartBtn.click();
		CartPage cartPage = new CartPage(driver);
	     return cartPage;
	}

}
