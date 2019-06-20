package testmeapp.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class frames {
@Test
public void switchframes() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	driver.manage().window().maximize();
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();
	act.moveToElement(driver.findElement(By.linkText("Our Offices"))).perform();
	act.moveToElement(driver.findElement(By.xpath("//a[@href='contact.htm?id=chn']"))).click().perform();
	Thread.sleep(300);
}
}
