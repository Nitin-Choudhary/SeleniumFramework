package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR
	@FindBy(name ="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page objects using initElements of pageFactory
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions: on login page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLog() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.sendKeys(Keys.ENTER);
		return new HomePage();
	}
}
