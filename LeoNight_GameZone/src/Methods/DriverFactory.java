package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
		public static WebDriver open(String browserType) {
		//This method will return a webdriver object
	if(browserType.equalsIgnoreCase("chrome")) {
		//execute chrome code
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Miiiii\\\\Desktop\\\\selenium\\\\software\\\\chromedriver.exe");
		return new ChromeDriver();
	}
	else if (browserType.equalsIgnoreCase("InternetExplorer")) {
		System.setProperty("webdriver.IExplorer.driver", "C:\\Users\\Miiiii\\Desktop\\selenium\\software\\IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
	else {
		//execute firefox code
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Miiiii\\Desktop\\selenium\\software\\geckodriver.exe");
		return new FirefoxDriver();
		
		}
	}
}