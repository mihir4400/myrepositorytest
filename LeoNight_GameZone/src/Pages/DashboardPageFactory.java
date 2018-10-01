package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {
	WebDriver driver;
	
	@FindBy(id="conf_message")
	WebElement confMessageLabel;
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLinkText;
	
	public String confirmationMessage() { //here we did not use "void" because we want to get something which is string(get message) so we used String in the declaration.
		return confMessageLabel.getText();
	}
	public String pageTitle() {
		return driver.getTitle();
	}
	public void changePasswordLinkText() {    //we are not defining any object inside ChangePasswordLinkText() because we are going to click the linktext.
		changePasswordLinkText.click();
	}
	
	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver; //here we are assisining the "driver" defined in this constructor to the local variable "driver" defined up there in class.
		PageFactory.initElements(driver, this);//Here, to initialize all the webelements we have defined at class level we have to
	}											// call the PageFactory method. If this isn't done we might fail our tests and cause
}												//	NullPointerException.
	

