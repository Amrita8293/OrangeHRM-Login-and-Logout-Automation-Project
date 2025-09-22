package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}

	@BeforeMethod
	public void setup() {
	    WebDriverManager.chromedriver().setup();   
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    System.out.println("Browser launched");
	}
	
	@AfterMethod
	public void teardown() {
	/*	if (driver != null) {
            driver.quit();
        }*/
		driver.quit();
        System.out.println("Test finished ...");
    }

}
