package Tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.LoginPage;

public class Login {
	@Test
	public void LoginTestPOM() {
		// 1. Initialize the webdriver.
		WebDriver driver = Methods.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Enter Login Info. (Login Page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassWord("trpass");
		loginPage.clickSubmit();
		
		//Get Conf (Dashboard Page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();
		System.out.println(conf);
		Assert.assertTrue(conf.contains("success"));
		String pageTitle = dashboardPage.pageTitle();
		Assert.assertTrue(pageTitle.contains("Account"));
		//Close the driver
		driver.quit();
	}
}
