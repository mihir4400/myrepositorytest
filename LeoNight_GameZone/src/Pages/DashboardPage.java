package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	
	public String confirmationMessage() { //here we did not use "void" because we want to get something which is string(get message) so we used String in the declaration.
		return driver.findElement(By.id("conf_message")).getText();
	}
	public String pageTitle() {
		return driver.getTitle();
	}
	public void changePasswordLinkText() {    //we are not defining any object inside ChangePasswordLinkText() because we are going to click the linktext.
		driver.findElement(By.linkText("Change password")).click();
	}
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver; //here we are assisining the "driver" defined in this constructor to the local variable "driver" defined up there in class.
	}
}
