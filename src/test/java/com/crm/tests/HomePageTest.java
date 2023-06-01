package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		loginPage = new LoginPage();
		loginPage.clickOnEnglishLink();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home page title is not matching");
	}
	
	@Test(priority = 2)
	public void verifyLoggedInUser() 
	{
		boolean flag = homePage.getLoggedInUser();
		Assert.assertTrue(flag);		
	}
	
	@Test(priority = 3)
	public void verifyClickOnContactsLinkTest()
	{
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
