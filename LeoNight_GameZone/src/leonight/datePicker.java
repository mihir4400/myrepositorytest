package leonight;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class datePicker {
		WebDriver driver = Methods.DriverFactory.open("chrome");
		
		@Before
		public void setUp() {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
		}
		@Test
		public void pickDate() {
			List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
				for(WebElement month:months) {
					if(month.getText().equalsIgnoreCase("jan")) {
						month.click();
						break;
					}	
				}
			List<WebElement> days = driver.findElements(By.xpath("//select[@id='day']/option"));
				for(WebElement day:days) {
					if(day.getText().equalsIgnoreCase("12")) {
						day.click();
						break;
					}
				}
				List<WebElement> years = driver.findElements(By.xpath("//select[@id='year']/option"));
					for(WebElement year:years) {
						if(year.getText().equalsIgnoreCase("1993")) {
							year.click();
							break;
						}
					}
				
	}
}
