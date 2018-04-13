package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public HomePageTest() {
		super();
	}
//test cases should be separated -- independent of each other
// before each test case -- launch the browser and login
//@test -- execute test case
// after each test case -- close the browser
	
	@BeforeMethod
	public void setup() {
	initialization();
	loginPage = new LoginPage();
	testUtil = new TestUtil();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.checkHomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title does not match");
		}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactslinkTest() {
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
