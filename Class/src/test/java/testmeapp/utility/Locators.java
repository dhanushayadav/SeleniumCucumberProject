package testmeapp.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locators {
@Test
public void test() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhanusha.p.yadav\\Class\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.google.co.in/");
	driver.manage().window().maximize();
	String actual=driver.getTitle();
	Assert.assertEquals(actual,"Google");
	WebElement div=driver.findElement(By.id("SIvCob"));
	List<WebElement> List=div.findElements(By.tagName("a"));
	int actual1=List.size();
	Assert.assertEquals(actual1, 9);	
}
}
