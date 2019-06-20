package testmeapp.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testmeapp.utility.Drivers;

public class OnlineShoppingTest {
WebDriver driver;
Actions act;
ExtentHtmlReporter Reporter;


@Test(priority=1)
public void browser(){
	driver =Drivers.getDriver("chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
  @Test(priority=2, enabled=false)
  public void testRegistration() {
	  //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	  driver =Drivers.getDriver("chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.linkText("SignUp")).click();
	  String Title=driver.getTitle();
	  Assert.assertTrue(Title.contains("Sign Up"));
	  driver.findElement(By.id("userName")).sendKeys("sa12309");
	  driver.findElement(By.id("firstName")).sendKeys("asdfghjkl");
	  driver.findElement(By.id("lastName")).sendKeys("fgh");
	  driver.findElement(By.id("password")).sendKeys("qwertyuiop");
	  driver.findElement(By.id("pass_confirmation")).sendKeys("qwertyuiop");
	  driver.findElement(By.cssSelector("input[value='Female']")).click();
	  driver.findElement(By.id("emailAddress")).sendKeys("qwertyy@asd.zxc");
	  driver.findElement(By.id("mobileNumber")).sendKeys("1234567899");
	  driver.findElement(By.id("dob")).sendKeys("14/06/2019");
	  driver.findElement(By.id("address")).sendKeys("123,we,argvyuknl");
	  driver.findElement(By.cssSelector("option[value='411013']")).click();
	  driver.findElement(By.id("answer")).sendKeys("asd");
	  driver.findElement(By.cssSelector("input[value='Register']")).click();
  }
@Test(priority=3)
  public void testLogin() {
	  driver.findElement(By.cssSelector("i[class='fa fa-lock']")).click();
	  String Title1= driver.getTitle();
	  Assert.assertEquals(Title1,"Login");
	  //Assert.assertTrue(Title1.contains("Login"));
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.cssSelector("input[class='btn btn-lg btn-success col-xs-4 col-md-offset-0']")).click(); 
  }
@BeforeTest
public void startReportbeforeTest() {
	
}
@AfterTest
public void endReportAfterTest() {
	System.out.println("After Test");
}
@Test(priority=4)
public void testCart() {
	act=new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("All Categories"))).perform();
	driver.findElement(By.partialLinkText("Electronics")).click();
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Head")));
	act.click((driver.findElement(By.partialLinkText("Head Phone")))).perform();
	driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-shopping-cart']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
	driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
}
@Test(priority=5)
public void testPayment() throws InterruptedException {
	Assert.assertEquals(driver.getTitle(), "Cart Checkout");
	driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	driver.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]")).click();
	driver.findElement(By.id("btn")).click();
	driver.findElement(By.name("username")).sendKeys("123459");
	driver.findElement(By.name("password")).sendKeys("Pass@459");
	driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
	Assert.assertEquals(driver.getTitle(), "Payment Gateway");
	driver.findElement(By.name("transpwd")).sendKeys("Trans@459");
	driver.findElement(By.cssSelector("input[value='PayNow']")).click();
	Assert.assertEquals(driver.getTitle(), "Order Details");
	driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
}
}







/*WebDriverWait wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Indian Bank']")));
Thread.sleep(3000);*/
