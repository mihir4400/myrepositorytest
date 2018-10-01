package leonight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_account {

	public static void main(String[] args) {
		
		//set up the webdriver.
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Miiiii\\Desktop\\selenium\\software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//finding the element, navigate to the website.
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//Find the Click Account label and click on it.
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		//Enter the name field by sendkeys method.
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Thomas George");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("thomasg0909@testmail.com");
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("9090873993");
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword'][name='ctl00$MainContent$txtPassword']")).sendKeys("12345");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("12345");				
		//select the option using radio button
		driver.findElement(By.id("MainContent_Male")).click();
		//From the dropdown list select visible country
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");
		//select the checkboxes 
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		//click on the submit button
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		//call the gettext() method to get the confirmation message on the browser window
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Confirmation: " +conf);
		//close the webdriver using the close() method
		driver.close();
		}
	}

