package com.crm.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialization();
		loginPage = new LoginPage();
		loginPage.clickOnEnglishLink();
	}
	
	@Test(priority = 1)
	public void verifyLandingPageTitle()
	{
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, "Free CRM Software for every business");
	}
	
	@Test(priority = 2)
	public void verifyLogin()
	{
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
