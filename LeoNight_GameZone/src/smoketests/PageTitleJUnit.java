package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class PageTitleJUnit {
		//Declare variables and objects at class level in order to declare them throughout the program.
		WebDriver driver;
		String WebUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";		
		@Test
		public void PageTitleTest() {
			System.out.println("Running the test");			
			driver.get(WebUrl);
			driver.findElement(By.linkText("CREATE ACCOUNT")).click();				
			String actualPageTitle = driver.getTitle();
			String expectedPageTitle = "SDET Training | Register New Account";
			Assert.assertEquals(expectedPageTitle, actualPageTitle);
		}	
		@Before
		public void setUp() {
			System.out.println("Initializing the driver");
			driver = Methods.DriverFactory.open("chrome");
		}
		@After
		public void tearDown() {
			System.out.println("closing the test");
			System.out.println("CLosing the driver");
			driver.close();
		}
}