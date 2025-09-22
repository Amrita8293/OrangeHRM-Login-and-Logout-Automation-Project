package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	@Test(priority=0)
	public void TC_01_ValidCredentials() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Admin");
		lpage.setPassword("admin123");
		lpage.clickLoginButton();
		
		HomePage hpage = new HomePage(driver);	
		Assert.assertTrue(hpage.gethomepagetitle().contains("OrangeHRM"));
	}

	@Test(priority=1)
	public void TC_02_InvalidCredentials() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Abcde");
		lpage.setPassword("abcde456");
		lpage.clickLoginButton();
		
		String expErrorMessage = "Invalid credentials";
		String actErrorMessage = lpage.getErrorMessage();
		Assert.assertEquals(actErrorMessage, expErrorMessage);
	}
	@Test(priority=2)
	public void TC_03_InvalidUsernameAndValidPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Abcde456");
		lpage.setPassword("admin123");
		lpage.clickLoginButton();
		
		String expErrorMessage = "Invalid credentials";
		String actErrorMessage = lpage.getErrorMessage();
		Assert.assertEquals(actErrorMessage, expErrorMessage);
	}
	@Test(priority=3)
	public void TC_04_ValidUsernameAndInvalidPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Abcde456");
		lpage.setPassword("abcde456");
		lpage.clickLoginButton();
		
		String expErrorMessage = "Invalid credentials";
		String actErrorMessage = lpage.getErrorMessage();
		Assert.assertEquals(actErrorMessage, expErrorMessage);
	}
	@Test(priority=4)
	public void TC_05_BlankUsernameAndBlankPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("");
		lpage.setPassword("");
		lpage.clickLoginButton();
		
		String expRequiredMessage = "Required";
		String actRequiredMessage = lpage.getRequiredMessage();
		Assert.assertEquals(actRequiredMessage, expRequiredMessage);
	}
	@Test(priority=5)
	public void TC_06_BlankUsernameAndValidPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("");
		lpage.setPassword("admin123");
		lpage.clickLoginButton();
		
		String expRequiredMessage = "Required";
		String actRequiredMessage = lpage.getRequiredMessage();
		Assert.assertEquals(actRequiredMessage, expRequiredMessage);
	}
	@Test(priority=6)
	public void TC_07_BlankUsernameAndInvalidPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("");
		lpage.setPassword("abcDE125");
		lpage.clickLoginButton();
		
		String expRequiredMessage = "Required";
		String actRequiredMessage = lpage.getRequiredMessage();
		Assert.assertEquals(actRequiredMessage, expRequiredMessage);
	}
	@Test(priority=7)
	public void TC_08_ValidUsernameAndBlankPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Admin");
		lpage.setPassword("");
		lpage.clickLoginButton();
		
		String expRequiredMessage = "Required";
		String actRequiredMessage = lpage.getRequiredMessage();
		Assert.assertEquals(actRequiredMessage, expRequiredMessage);
	}
	@Test(priority=8)
	public void TC_09_InvalidUsernameAndBlankPassword() {
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername("Abcde");
		lpage.setPassword("");
		lpage.clickLoginButton();
		
		String expRequiredMessage = "Required";
		String actRequiredMessage = lpage.getRequiredMessage();
		Assert.assertEquals(actRequiredMessage, expRequiredMessage);
	}
	@Test(priority=9)
	public void TC_10_ForgotPassword() {
		LoginPage lpage = new LoginPage(driver);
        lpage.clickForgotPassword();
        
        String expResetPassword = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        String actResetPassword = driver.getCurrentUrl();
        
        Assert.assertEquals(actResetPassword, expResetPassword);
        

	}
}
