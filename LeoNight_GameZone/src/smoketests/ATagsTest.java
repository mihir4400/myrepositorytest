package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {

	WebDriver driver = Methods.DriverFactory.open("chrome");
	
	@Test	
	public void loginElementsPresentTest() {
		System.out.println("Executing the test");
		boolean createAccountPresent = false;
		//we want to test the presence for '<a>' tags(hyperlink)
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		/* int numberOfAElements = aElements.size();
		System.out.println("There are " + numberOfAElements + " a tags on the page");...........count the no of elements */
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());/*.....print the elements */
			if (aElement.getText().equalsIgnoreCase("Create Account")) {
				createAccountPresent = true;
				break;
			}
		}
		Assert.assertTrue(createAccountPresent);
	}	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting the test");
		String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.close();
	}
}
