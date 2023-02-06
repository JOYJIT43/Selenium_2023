  package pomFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomFramework.abstractUtilityComponents.ReusableUtility;

public class LandingPage extends ReusableUtility{
	
	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		//while execution and invocation this below line is responsible for bringing the pageelements to live
		//with Driver.findelements(By.....)
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement emailBox;
	
	@FindBy(id="userPassword")
	WebElement passwordBox;
	
	@FindBy(css=".login-btn")
	WebElement logInBtn;
	
	//method to Login
	public HomePage LogIn(String email, String password)
	{
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		logInBtn.click(); 
		return new HomePage(driver);
		
	}
	
	public void OpenApplication()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
//driver.findElement(By.id("userEmail")).sendKeys("joyjitghosh98@gmail.com");
//driver.findElement(By.id("userPassword")).sendKeys("vpsWikFc@Dab9dB");
//
////click on login
//driver.findElement(By.cssSelector(".login-btn")).click();