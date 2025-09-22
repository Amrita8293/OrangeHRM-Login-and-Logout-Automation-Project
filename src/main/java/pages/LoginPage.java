package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;
	
	 	
		By username = By.name("username");
		By password = By.name("password");
		By loginbutton = By.xpath("//button[@type='submit']");
		By errormessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
		By requiredmessage = By.xpath("//span[text()='Required']");
		By forgotpassword = By.xpath("//p[text()='Forgot your password? ']");
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void setUsername(String uname) {
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(uname);
		}
		
		public void setPassword(String pass) {
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys(pass);
		}
		public void clickLoginButton() {
			driver.findElement(loginbutton).click();
			
		}
		public String getErrorMessage() {
			return driver.findElement(errormessage).getText();
		}
		public String getRequiredMessage() {
			return driver.findElement(requiredmessage).getText();
		}
		public void clickForgotPassword() {
			driver.findElement(forgotpassword).click();
		}
}
