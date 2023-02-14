package pomFramework.TestReusableUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomFramework.pageObjects.LandingPage;

public class BaseTest<ListhashMapData> {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public JavascriptExecutor js ;
	
	public WebDriver initialization() throws IOException
	{
		String propFilePath= System.getProperty("user.dir")+"\\src\\main\\java\\pomFramework\\Resources\\GlobalData.properties";
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		
		//The first condition helps us to take input from the command line
		String browserName=  System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
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
	
	public List<HashMap<String, String>> dataReader(String filePath) throws IOException
	{
	    //read json to string
		String jsonContent = 	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap- Jackson Databind get maven dependencies
		
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data;
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		
//		List 
//	}

}

