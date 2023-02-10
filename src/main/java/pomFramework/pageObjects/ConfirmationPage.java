package pomFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomFramework.abstractUtilityComponents.ReusableUtility;

public class ConfirmationPage extends ReusableUtility{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".hero-primary")
	WebElement successMsgField;
	
	public String getSuccessMsg()
	{
		return successMsgField.getText().trim();
	}
	

}
