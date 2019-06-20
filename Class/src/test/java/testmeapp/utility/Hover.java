package testmeapp.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hover {
@Test
public void CardTest() throws InterruptedException {
	System.setProperty("webdriver.Chrome.Driver", "C:\\Users\\dhanusha.p.yadav\\Class\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.hdfcbank.com");
	driver.manage().window().maximize();
	//String actual=driver.getTitle();
	Assert.assertTrue(driver.getTitle().contains("HDFC Bank"));
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
	Thread.sleep(300);
	act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
	Thread.sleep(300);
	act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']"))).click().perform();
	Assert.assertTrue(driver.getCurrentUrl().endsWith("Credit_Cards"));
}
}
