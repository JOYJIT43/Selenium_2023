package pomFramework.pageObjects;

import org.openqa.selenium.WebDriver;
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
	
	
}
