package com.maveric.initialization;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.maveric.utilities.PropertiesHandler;

public class LauchActivities {

	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void initialization(@Optional("ch") String browser) throws IOException
	// when no data comes then use optional string/int etc as per return type in parameter
	{
		System.out.println(browser);
	
	lauchBrowser(browser);
	prop=PropertiesHandler.getPropertiesDetails("Utilities/Data.properties");
	wait = new WebDriverWait(driver,50);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // without implicit the methods will work but we need to add the explicit object if requrired
	driver.manage().window().maximize();
	
	
	}
	
	@AfterTest(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void lauchBrowser(String browser)
	{
		switch (browser.toLowerCase()) {
		case "ch":
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver=new ChromeDriver();
			break;
			
		case "ie":
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
			driver=new ChromeDriver();
			break;

		default:
			break;
		}
}
}
