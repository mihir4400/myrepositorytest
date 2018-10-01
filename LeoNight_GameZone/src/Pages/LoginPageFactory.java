package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
WebDriver driver;

	@FindBy(id="MainContent_txtUserName")
	WebElement  userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginClick;
	
	//Steps for login
	public void setUserName(String username) { // we defined the username in here because we are using sendkeys() to enter username.
		userNameBox.sendKeys(username);
	}
	public void setPassWord(String password) {
		passwordBox.sendKeys(password);
	}
	public void clickSubmit() {
		loginClick.click();
	}
	//Action
	public void login(String username, String password) {
		setUserName(username);
		setPassWord(password);
		clickSubmit();
	}	
	//Constructor initializes the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //Here, to initialize all the webelements we have defined at class level we have to
	}											// call the PageFactory method. If this isn't done we might fail our tests and cause
}												//	NullPointerException.
	

