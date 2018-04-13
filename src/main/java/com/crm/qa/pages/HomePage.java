package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Nitin C')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	//Initializing the page objects using initElements of pageFactory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions on Home Page
	public String checkHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactPage clickOnContactPage() {
		contactLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDealPage() {
		dealLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		taskLink.click();
		return new TasksPage();
	}	
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		}
	
}
