package Tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
		
	String browserType = "chrom";	
	WebDriver driver = Methods.DriverFactory.open(browserType);
	String city = "New York, NY";
	String starRating = "star4";
	String searchResult = "3";
		
	@Test
	public void hotelReservation() {
		System.out.println("Executing the test");
		WebElement hotelTabElement = driver.findElement(By.id("tab-hotel-tab-hp"));
		hotelTabElement.click();  //click on the hotel tab on the expedia home page	
		WebElement cityElement = driver.findElement(By.id("hotel-destination-hp-hotel"));
		cityElement.clear();
		cityElement.sendKeys(city); //Enter the city input field
		WebElement checkInTab = driver.findElement(By.id("hotel-checkin-hp-hotel"));		
		checkInTab.click(); //click to open the check in date selector
		WebElement checkInValue = driver.findElement(By.cssSelector("button[class='datepicker-cal-date'][type='button'][data-year='2018'][data-month='7'][data-day='25']"));
		checkInValue.click();
		WebElement checkOutTab = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		checkOutTab.click();
		WebElement checkOutValue = driver.findElement(By.cssSelector("button[class='datepicker-cal-date'][type='button'][data-year='2018'][data-month='7'][data-day='27']"));
		checkOutValue.click();
		WebElement travellerInfoTab = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")); 
		travellerInfoTab.click();
		WebElement travellerAdultDecrement = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[2]/div[2]/button"));
		travellerAdultDecrement.click();
		WebElement travellerTabClose = driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div[2]/div[2]/section[2]/form/div[4]/div[3]/div/ul/li/div/footer/div/button")); 
		travellerTabClose.click();
		WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn-primary btn-action  gcw-submit'][type='submit'][data-gcw-change-submit-text='Search']"));
		searchButton.click();
		
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("City: " +actualCity);
		
		WebElement starFourBox = driver.findElement(By.cssSelector("input[id='"+starRating+"'][name='star'][type='checkbox']"));
		starFourBox.click();
		
		WebElement selectSearchResult = driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article["+searchResult+"]/div[2]/div/a"));
		selectSearchResult.click();
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles()); //here, (driver.getWindowHandles()) is a constructor.
		driver.switchTo().window(windows.get(1)); //rule: 1 is the second index as the list starts with 0.
		
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println("The hotel is: " +hotelName);
		
		WebElement reserveButton = driver.findElement(By.cssSelector("button[type='submit'][class='book-button btn-pwa btn-action']"));
		reserveButton.click();
				
		
		//WebElement payOnlineButton = driver.findElement(By.id("pay-now-button"));
		//payOnlineButton.click();
		
		String hotlePrice = driver.findElement(By.cssSelector("span[class='summary-total amount-value'][data-price-update='total']")).getText();
		System.out.println("Price for the "+hotelName+" is "+hotlePrice);
		
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	@BeforeMethod
	public void setUp() {
		System.out.println("Setting up the test");
		String webUrl = "https://www.expedia.com/";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(webUrl);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}
