package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Prosenjit  B']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLnk;
	
	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLnk;
	
	//Initialize web elements
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean getLoggedInUser()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLnk.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLnk.click();
		return new DealsPage();
	}

}
