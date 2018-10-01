package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {       ////This "LoginPage" is an object we will call in the Login Test method in a different class by importing this object and defining it.
	
	WebDriver driver;
	
	public void setUserName(String username) { // we defined the username in here because we are using sendkeys() to enter username.
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	public void setPassWord(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	public void clickSubmit() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	//Constructor initializes the state of the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
}
