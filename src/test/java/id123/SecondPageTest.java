package id123;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.Inventory;

public class SecondPageTest {
	
	private WebDriver driver; 
	
	@BeforeClass (alwaysRun=true)
	public void setUp () {
		String dir = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");//useful for github 
		//allows everyone to access to their webdriver path 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //waiting in seconds 
		driver.manage().window().maximize(); //maximizing the screen 
		driver.get("https://www.saucedemo.com/"); //openes a specific webpage
		//enter inventory page
		HomePage hp = new HomePage(driver); 
		hp.logInCorrectly();
	}
	
	@Test (priority=1)
	public void clickOnBikeLightAndTestCart () {
		Inventory inv = new Inventory(driver);
		inv.clickOnBikeLight();
		int numberOfItems = inv.numberOfItemsInCart(); 
		int expectedNumber = 1; 
		Assert.assertEquals(numberOfItems, expectedNumber, "Number of items in shopping cart doesn't match with expected.");
	}
	
	@Test (priority=2)
	public void clickOnOnesieAndTestCart () {
		Inventory inv = new Inventory(driver);
		inv.clickOnOnesie();
		int numberOfItems = inv.numberOfItemsInCart(); 
		int expectedNumber = 2; 
		Assert.assertEquals(numberOfItems, expectedNumber, "Number of items in shopping cart doesn't match with expected.");
	}
	
	@Test (priority=3)
	public void testIfOnRightPage () {
		Inventory inv = new Inventory(driver); 
		CartPage cp = inv.enterCart();
		Assert.assertEquals(cp.getURL(), "https://www.saucedemo.com/cart.html", "URL doesn't match.");
	}

	// name, price, quantity
	@Test (priority=4)
	public void testFirstElementInCart () {
		CartPage cp = new CartPage(driver); 
		ArrayList<String> bikeList = cp.bikeElements(); 
		Assert.assertEquals(bikeList.get(0), "Sauce Labs Bike Light", "Name of the first element not as expected.");
		Assert.assertEquals(bikeList.get(1), "9.99", "Price of the first element not as expected.");
		Assert.assertEquals(bikeList.get(2), "1", "Quantity of the first element not as expected.");
	}
	
	@Test (priority=5)
	public void testSecondElementInCart () {
		CartPage cp = new CartPage(driver); 
		ArrayList<String> onesieList = cp.onesieElements(); 
		Assert.assertEquals(onesieList.get(0), "Sauce Labs Onesie", "Name of the second element not as expected.");
		Assert.assertEquals(onesieList.get(1), "7.99", "Price of the second element not as expected.");
		Assert.assertEquals(onesieList.get(2), "1", "Quantity of the second element not as expected.");
	}
	
	
}
