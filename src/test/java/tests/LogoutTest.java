package tests;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

//@Listeners(listeners.mylisteners.class)

public class LogoutTest extends BaseTest{
	
	@Test
	public void TC_11_Userlogout() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Admin");
		lpage.setPassword("admin123");
		lpage.clickLoginButton();
		
		HomePage hpage = new HomePage(driver);
		hpage.clicklogout();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
		
		
		
	}

}
