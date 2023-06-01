package com.crm.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtils;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest()
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
		contactsPage = homePage.clickOnContactsLink();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		contactsPage.clickOnElement("Address");
		//contactsPage.WaitTillElementVisible();
	}
	
	@Test(priority = 1)
	public void VerifyContactsLabelIsDisplayedTest() {
		Assert.assertTrue(contactsPage.isContactsLabelDisplayed(), "Contacts label is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyContactIsChecked()
	{
		contactsPage.selectContactByName("Pro B");
		String classValue = contactsPage.isContactChecked("Pro B");
		Assert.assertEquals(classValue, "ui checked fitted read-only checkbox", "The contact selected is not checked");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getTestData")
	public void verifyCreateNewContact(String firstName, String lastName, String company, String categoryName)
	{
		contactsPage.createNewContact(firstName, lastName, company, categoryName);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
