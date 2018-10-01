package leonight;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cityPicker {

	public static void main(String[] args) {
		
		String browserType ="chrome";						
		//webdriver algorithm
		WebDriver driver;
		driver = Methods.DriverFactory.open(browserType);
		
		//navigate to the website
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
				List<WebElement> states = driver.findElements(By.xpath("//select[@id='MainContent_menuCountry']//option"));
				System.out.println("The total number of states are " +states.size());
				for(WebElement state:states) {
					System.out.println("The state is " +state.getText());
					if(state.getText().equalsIgnoreCase("finland"));
					state.click();
					break;
				}
				//driver.close();

	}

}
