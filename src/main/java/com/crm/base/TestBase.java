package com.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.utils.TestUtils;
import com.crm.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try 
		{
			properties = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Prosenjit Bhowmick\\eclipse-workspace\\CRMApp_HybridFramework\\src\\main\\java\\com\\crm\\config\\config.properties");
			properties.load(fis);
						
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void Initialization()
	{
		String browser = properties.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prosenjit Bhowmick\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prosenjit Bhowmick\\Downloads\\Drivers");
			driver = new FirefoxDriver();
		}
		
		eventListener = new WebEventListener();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}

}
