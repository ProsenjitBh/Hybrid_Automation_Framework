package com.crm.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Logger log = LogManager.getLogger(LoginPageTest.class);
	
	
	public LoginPageTest()
	{
		super();		
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		loginPage = new LoginPage();
		loginPage.clickOnEnglishLink();
	}
	
	@Test(priority = 1)
	public void verifyLandingPageTitle()
	{
		PropertyConfigurator.configure("C:/Users/Prosenjit Bhowmick/eclipse-workspace/CRMApp_HybridFramework/src/main/resources/log4j.properties");
		log.info("******************************Starting verifyLandingPageTitle test execution**************************************************");
		String title = loginPage.getPageTitle();
		log.info("Title of Login Page : "+title);
		Assert.assertEquals(title, "Free CRM Software for every business");
		log.info("******************************Ending verifyLandingPageTitle test execution****************************************************");
	}
	
	@Test(priority = 2)
	public void verifyLogin()
	{
		log.info("**************************************Starting verifyLogin test execution*****************************************************");
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		log.info("Entering username : "+userName+ " and Password : "+password+ " as credentails");
		homePage = loginPage.login(userName, password);
		log.info("**************************************Ending verifyLogin test execution*******************************************************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("*******Closing browser**********");
	}
}
