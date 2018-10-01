package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	WebDriver driver;
	@Test(dataProvider = "getData")
	public void LoginTest(String name, String email, String password) {
		//interact with login elements.
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		//confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation:  " +message);
	}
	@BeforeMethod
	public void setUp() {
		driver = Methods.DriverFactory.open("chrome");
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider
	public String[][] getData() {
		return Methods.Excel.get("C:\\Users\\Miiiii\\Desktop\\selenium\\UserLogin.xls");
	}
}
