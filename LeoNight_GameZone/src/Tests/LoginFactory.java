package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.DashboardPageFactory;
import Pages.LoginPageFactory;

public class LoginFactory {
	
	String username = "tim@testemail.com";
	String password = "trpass";
	
	public void LoginTestPOM() {
		// 1. Initialize the webdriver.
		WebDriver driver = Methods.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username, password);
			
		//Get Conf (Dashboard Page)
		DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
		String conf = dashboardPage.confirmationMessage();
		System.out.println(conf);
		Assert.assertTrue(conf.contains("success"));
		String pageTitle = dashboardPage.pageTitle();
		Assert.assertTrue(pageTitle.contains("Account"));
		//Close the driver
		driver.quit();
	}
}
