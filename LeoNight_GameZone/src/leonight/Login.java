package leonight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. define web driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Miiiii\\Desktop\\selenium\\software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		//2. Open the browser and Navigate to leonight url
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//3.Enter the user id 
		 driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		//4.Enter the password.
		 driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		//5.Click login button.
		 driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		//6.Get the login confirmation message.
		 String message = driver.findElement(By.id("conf_message")).getText();
		 System.out.println("Confirmation:  " +message);
		//7.Close the browser.
		 String pageTitle = driver.getTitle();
		 System.out.println("Page Title: " +pageTitle);
		 driver.close();
	}
}
