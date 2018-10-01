package leonight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		String name = "Paul";
		String email = "paulfursland@testemail.com";
		String password ="100972223";
		String country ="Germany";
		String phoneNumber = "3492300923";
		String browserType ="chrome";						
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false;
		
		//webdriver algorithm
		WebDriver driver;
		driver = Methods.DriverFactory.open(browserType);
		
		//navigate to the website
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
				WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
				WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
				WebElement phElement = driver.findElement(By.id("MainContent_txtHomePhone"));
				WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][name='ctl00$MainContent$txtPassword']"));
				WebElement verifyPassElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
				WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
				WebElement maleRadioElement = driver.findElement(By.id("MainContent_Male"));
				WebElement femaleRadioElement  = driver.findElement(By.id("MainContent_Female"));
				WebElement weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
				WebElement monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
				WebElement submitButtonElement = driver.findElement(By.id("MainContent_btnSubmit"));
				WebElement occassionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
				
				//filling field by sndkys/click/gettext method.
				nameElement.sendKeys(name);
				emailElement.sendKeys(email);
				phElement.sendKeys(phoneNumber);
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
				if(occassionalEmail) {
					if(occassionalEmailElement.isSelected()) {
						occassionalEmailElement.click();
					}
				}
				else {
					if(!occassionalEmailElement.isSelected()) {
						occassionalEmailElement.click();
					}
				}    
							
				//submit button algorithm
				submitButtonElement.click();
				
				//call the gettext() method to get the confirmation message on the browser window and close browser
				String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
				String expected = "CUSTOMER INFORMATION ADDED SUCCESSFULLY";
				if (conf.equalsIgnoreCase(expected)) {
					System.out.println("Confirmation: " +conf);
				}
				else {
					System.out.println("Error: Account creation failed");
				}
				driver.close();

	}

}
