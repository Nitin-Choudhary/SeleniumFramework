package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName = "contacts";
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactPage =  new ContactPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactPage();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabelTest() {
		Assert.assertTrue(contactPage.verifyContactLabel(),"Contact label is missing on page");
	}
	
	@Test(priority=2)
	public void selectContactTest() {
		contactPage.selectContactsByName("Test1 Test1");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider = "getCRMTestData")
	public void validateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		//contactPage.createNewContact("Mr.", "Tom", "Jones", "Google");
		contactPage.createNewContact(title, firstName, lastName, company);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
