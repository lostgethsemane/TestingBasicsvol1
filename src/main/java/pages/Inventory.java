package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
	
	private WebDriver driver; 
	
	private By bikeLight = By.cssSelector(".inventory_list > div:nth-child(2) > div:nth-child(3) > .btn_primary.btn_inventory");
	private By onesie = By.cssSelector(".inventory_list > div:nth-child(5) > div:nth-child(3) > .btn_primary.btn_inventory"); 
	private By cartLocator = By.id("shopping_cart_container");
	private By cartNumberLocator = By.cssSelector("#shopping_cart_container > a > span"); 
	
	public Inventory (WebDriver driver) {
		this.driver = driver; 
	}
	
	public String getURL(){
		return driver.getCurrentUrl(); 
	}
	
	public void clickOnBikeLight () {
		driver.findElement(bikeLight).click();
	}
	
	public void clickOnOnesie () {
		driver.findElement(onesie).click();
	}
	
	public int numberOfItemsInCart () {
		return Integer.parseInt(driver.findElement(cartNumberLocator).getText()); 
	}
	
	public void cart () {
		driver.findElement(cartLocator).click(); 
	}
	
	public CartPage enterCart () {
		driver.findElement(cartLocator).click(); 
		return new CartPage(driver);
	}
}
