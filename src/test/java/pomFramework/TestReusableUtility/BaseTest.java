package pomFramework.TestReusableUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomFramework.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public JavascriptExecutor js;
	
	public WebDriver initialization() throws IOException
	{
		String propFilePath= System.getProperty("user.dir")+"\\src\\main\\java\\pomFramework\\Resources\\GlobalData.properties";
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		
		String browserName=  prop.getProperty("browser");
		
		switch(browserName)
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
		}
		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
		return driver;
		
	}
	
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		
        driver = initialization();
        landingPage = new LandingPage(driver);
        landingPage.OpenApplication();
        
	}
	
	public void getScreenshot()
	{
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		
//		List 
//	}

}

