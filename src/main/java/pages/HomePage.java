package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver; 
	
	private By logInButton = By.className("btn_action");
	private By errorText = By.cssSelector("[data-test=\"error\"]"); //tekst mora preko xpath-a
	private By passwordLocator = By.id("password"); 
	private By usernameLocator = By.id("user-name"); 
	
	private String password = "secret_sauce"; 
	private String username = "standard_user"; 
	
	public HomePage (WebDriver driver) {
		this.driver = driver; 
	}
	
	public void logInWithoutUP () {
		driver.findElement(logInButton).click();
	}

	public void logInWithoutU () {
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(logInButton).click();
	}
	
	public void logInWithoutP () {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(logInButton).click();
	}
	
	public String getURL () {
		return driver.getCurrentUrl();
	}
	
	public String getMessage () {
		return driver.findElement(errorText).getText(); 
	}
	
	public void logInCorrectly () {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(logInButton).click();
	}
	
	public Inventory enterInventory () {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(logInButton).click();
		return new Inventory(driver); 
	}
	
	public void tearDown () {
		driver.quit();
	}
	
}
