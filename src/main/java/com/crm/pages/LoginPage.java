package com.crm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	Logger log = LogManager.getLogger(LoginPage.class);
	
	//Page Factory - Object Repository
	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginLnk;
	
	@FindBy(xpath = "//span[text()='Sign Up']")
	WebElement signUpLnk;
	
	@FindBy(name = "email")
	WebElement emailTxt;
	
	@FindBy(name = "password")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='https://es.freecrm.com']")
	WebElement englishLnk;
	
	//Initializing the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnEnglishLink()
	{
		if(englishLnk.isDisplayed())
			englishLnk.click();
	}
	
	public HomePage login(String user, String password) 
	{
		loginLnk.click();
		emailTxt.sendKeys(user);
		passwordTxt.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}
}
