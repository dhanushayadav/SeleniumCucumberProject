package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Drivers {
	public static WebDriver getDriver(String Browser) {
		if(Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			return driver;
		}
		else if(Browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			WebDriver driver=new InternetExplorerDriver();
			return driver;
		}
		else if(Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			return driver;
		}
		else {
			return null;
		}
	}
	
	

}
