package id123;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class FirstPageTest {
	
	private WebDriver driver; 
	
	@BeforeClass 
	public void setUp () {
		String dir = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");//useful for github 
		//allows everyone to access to their webdriver path 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //waiting in seconds 
		driver.manage().window().maximize(); //maximizing the screen 
		driver.get("https://www.saucedemo.com/"); //openes a specific webpage
	}
	
	@Test(priority=1)
	public void enterNothingAndTestMessage () {
		HomePage home = new HomePage(driver);
		home.logInWithoutUP();
		Assert.assertEquals(home.getURL(), "https://www.saucedemo.com/", "User is not on the correct page");
		String message = home.getMessage(); 
		Assert.assertEquals(message, "Epic sadface: Username is required", "Expected message not found");
	}

	
	@Test(priority=2)
	public void enterPasswordAndTestMessage () {
		HomePage home = new HomePage(driver); 
		home.logInWithoutU(); 
		Assert.assertEquals(home.getURL(), "https://www.saucedemo.com/", "User is not on the correct page");
		String message = home.getMessage(); 
		Assert.assertEquals(message, "Epic sadface: Username is required", "Expected message not found");
	}
	
	@Test(priority=3)
	public void enterUsernameAndTestMessage () {
		HomePage home = new HomePage(driver); 
		home.logInWithoutP(); 
		Assert.assertEquals(home.getURL(), "https://www.saucedemo.com/", "User is not on the correct page");
		String message = home.getMessage(); 
		Assert.assertEquals(message, "Epic sadface: Password is required", "Expected message not found");
	}
	
	@AfterMethod
	public void goToFirstPage () {
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterClass
	public void tearDown () {
		HomePage home = new HomePage (driver);
		home.tearDown();
	}

}
