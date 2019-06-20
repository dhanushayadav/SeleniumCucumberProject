package testmeapp.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actions {
@Test
public void locators() {
	System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  WebElement from=driver.findElement(By.cssSelector("span[class='rtText']"));
	  WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
	  Actions act=new Actions(driver);
	  act.dragAndDrop(from, to).perform();
	  
}
}
