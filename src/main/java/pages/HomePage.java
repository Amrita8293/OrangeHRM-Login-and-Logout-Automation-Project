package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;

			
		By usericon = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
		By logout = By.xpath("//a[text()='Logout']");
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void clicklogout() {
			driver.findElement(usericon).click();
			driver.findElement(logout).click();
		}
		
		public String gethomepagetitle() {
			return driver.getTitle();
		}
}
