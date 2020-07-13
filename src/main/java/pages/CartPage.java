package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private WebDriver driver; 
	
	private By bikeLightElement_loc = By.cssSelector("#item_0_title_link > .inventory_item_name"); 
	private By bikeLightPrice_loc = By.cssSelector("#item_0_title_link ~ .item_pricebar > .inventory_item_price"); 
	private By bikeLightQuantity_loc = By.cssSelector(".cart_list > div:nth-child(3) > .cart_quantity"); 
	
	private By onesieElement_loc = By.cssSelector("#item_2_title_link > .inventory_item_name"); 
	private By onesiePrice_loc = By.cssSelector("#item_2_title_link ~ .item_pricebar > .inventory_item_price"); 
	private By onesieQuantity_loc = By.cssSelector(".cart_list > div:nth-child(4) > .cart_quantity"); 
	
	public CartPage (WebDriver driver) {
		this.driver = driver; 
	}
	
	public String getURL () {
		return driver.getCurrentUrl();
	}
	
	
	// name, price, quantity
	public ArrayList<String> bikeElements () {
		ArrayList<String> bikeList = new ArrayList<String> (); 
		bikeList.add(driver.findElement(bikeLightElement_loc).getText());
		bikeList.add(driver.findElement(bikeLightPrice_loc).getText()); 
		bikeList.add(driver.findElement(bikeLightQuantity_loc).getText()); 
		return bikeList; 

	}
	public ArrayList<String> onesieElements () {
		ArrayList<String> onesieList = new ArrayList<String> (); 
		onesieList.add(driver.findElement(onesieElement_loc).getText());
		onesieList.add(driver.findElement(onesiePrice_loc).getText()); 
		onesieList.add(driver.findElement(onesieQuantity_loc ).getText()); 
		return onesieList; 
	}
}
