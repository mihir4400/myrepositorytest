package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	
	WebDriver driver = Methods.DriverFactory.open("chrome");
	
	@Test	
	public void loginElementsPresentTest() {
		System.out.println("Executing the test");
		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean loginPasswordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		boolean loginLoginButton = driver.findElement(By.id("MainContent_btnLogin")).isDisplayed();
		Assert.assertTrue(loginEmailBox, "Login Email box Present");
		Assert.assertTrue(loginPasswordBox, "Login Password Not Present");
		Assert.assertTrue(loginLoginButton);
	}	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting the test");
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.close();
	}
}
