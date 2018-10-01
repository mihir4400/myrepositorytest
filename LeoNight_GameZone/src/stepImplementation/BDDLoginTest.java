package stepImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	WebDriver driver = Methods.DriverFactory.open("chrome");
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("user is on the login page");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	@When("^user enters the correct username and correct password$")
	public void user_enters_the_correct_username_and_correct_password() {
		System.out.println("user enters username and password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
	}
	@When("^user enters email (.*)$")
	public void user_enters_username(String username) {
		System.out.println("User enters username " +username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	@And("^user enters password (.*)$")
	public void users_enters_password(String password) {
		System.out.println("User enters password " +password);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	@And("^user clicks the login button$")
	public void user_clicks_the_login_button() {
		System.out.println("user clicks the login button");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("user gets the confirmation");
		String conf_message = driver.findElement(By.id("conf_message")).getText();
		Assert.assertTrue(conf_message.contains("success"));
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
