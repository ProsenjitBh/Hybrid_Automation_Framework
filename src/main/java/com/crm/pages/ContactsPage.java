package com.crm.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "(//span[text()='Contacts'])[2]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//th[text()='Address']")
	WebElement AddressHeaderLabel;
	
	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement createLnk;
	
	@FindBy(name = "first_name")
	WebElement firstNametxt;
	
	@FindBy(name = "last_name")
	WebElement lastNametxt;
	
	@FindBy(xpath = "//div[@name='company']/input")
	WebElement companytxt;
	
	@FindBy(name = "category")
	WebElement categoryDropdown;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isContactsLabelDisplayed()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		WebElement element = driver.findElement(By.xpath("//table[@class='ui celled definition sortable striped table custom-grid']/tbody/tr/td[2]/a[text()='"+name+"']/../../td[1]/div"));
		element.click();
	}
	
	public String isContactChecked(String name)
	{
		WebElement element = driver.findElement(By.xpath("//table[@class='ui celled definition sortable striped table custom-grid']/tbody/tr/td[2]/a[text()='"+name+"']/../../td[1]/div"));
		String propertyValue = element.getAttribute("class");
		return propertyValue;
	}
	
	public void clickOnElement(String value)
	{
		WebElement element = driver.findElement(By.xpath("//th[text()='"+value+"']"));
		element.click();
	}
	
	public void WaitTillElementVisible()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[text()='Name']")));
	}
	
	public void selectCategory(String categoryName)
	{
		categoryDropdown.click();
		driver.findElement(By.xpath("//div[@name='category']/div[2]/div/span[contains(text(),'"+categoryName+"')]")).click();
	}
	
	public void createNewContact(String firstName, String lastName, String company, String categoryName) 
	{
		createLnk.click();
		firstNametxt.sendKeys(firstName);
		lastNametxt.sendKeys(lastName);
		companytxt.sendKeys(company);
		selectCategory(categoryName);
		saveBtn.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
