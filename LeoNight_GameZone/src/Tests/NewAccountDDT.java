package Tests;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameElement, emailElement, phElement, passwordElement, verifyPassElement, countryElement, maleRadioElement,
			 	femaleRadioElement, weeklyEmailElement, monthlyEmailElement, occasionalEmailElement, submitButtonElement;
	WebDriver driver = Methods.DriverFactory.open("chrome");
	@Before
	public void setUp() {
		System.out.println("Setting up the test");
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
	}		
	public void defineWebElements() {
		//find the web elements.
		 nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		 emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		 phElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		 passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][name='ctl00$MainContent$txtPassword']"));
		 verifyPassElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		 countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		 maleRadioElement = driver.findElement(By.id("MainContent_Male"));
		 femaleRadioElement  = driver.findElement(By.id("MainContent_Female"));
		 weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		 monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		 submitButtonElement = driver.findElement(By.id("MainContent_btnSubmit"));
		 occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));	
	}
	@Test   	//This is our test method
	public void newAccountTest() {
		System.out.println("New Record: " +name+ " " +email+ " " +phone+ " " +gender+ " " +password+ " " +country+ " " +weeklyEmail+ 
				" " +monthlyEmail+ " " +occasionalEmail);						
				//define webElements by calling defineWebElements function defined previously
				defineWebElements(); 
				//filling field by sndkys/click/gettext method.
				nameElement.sendKeys(name);
				emailElement.sendKeys(email);
				phElement.sendKeys(phone);
				passwordElement.sendKeys(password);
				verifyPassElement.sendKeys(password);				
				new Select(countryElement).selectByVisibleText(country);
				//Gender radio button algorithm
				if(gender.equalsIgnoreCase("Male")) { maleRadioElement.click(); }
				else { femaleRadioElement.click(); }	
				//checkbox algorithm
				if(weeklyEmail) {
					if(weeklyEmailElement.isSelected()) {
						weeklyEmailElement.click();
					}
				}
				else {
					if(!weeklyEmailElement.isSelected()) {
						weeklyEmailElement.click();
					}
				}				
				if(monthlyEmail) {
					if(monthlyEmailElement.isSelected()) {
						monthlyEmailElement.click();
					}
				}
				else {
					if(!monthlyEmailElement.isSelected()) {
						monthlyEmailElement.click();
					}
				}
				if(occasionalEmail) {
					if(occasionalEmailElement.isSelected()) {
						occasionalEmailElement.click();
					}
				}
				else {
					if(!occasionalEmailElement.isSelected()) {
						occasionalEmailElement.click();
					}
				}    
				//submit button algorithm
				//submitButtonElement.click();		
		/* if(phone.equals("7894561230")) {
			Assert.fail(); }...can use this operation to fail any one tests for particular record */
	}
	@After
	public void tearDown() {
		System.out.println("Terminating the test");
		driver.close();
	}
	//This method is designed to pass parameters in to the class VIA constructor.
	@Parameters
	public static List<String[]> getData() {
		return Methods.CSV.get("C:\\Users\\Miiiii\\Desktop\\selenium\\UserAccounts.csv");
	}
	/*constructor that passes parameters to the test method. 
	 //constructor is a method that has the same name as the class
	and there is no return type */
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, 
			String weeklyEmail, String monthlyEmail, String occasionalEmail) {
			
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.gender = gender;
			this.password = password;
			this.country = country;
			//checkbox algorithm
			if(weeklyEmail.equals("TRUE")) { this.weeklyEmail = true; }
			else { this.weeklyEmail = false; }
			if(monthlyEmail.equals("TRUE")) { this.monthlyEmail = true; }
			else { this.monthlyEmail = false; }
			if(occasionalEmail.equals("TRUE")) { this.occasionalEmail = true; }
			else { this.occasionalEmail = false; }
	}
}
