package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {

	
	@FindBy(xpath = "//*[@class='fa fa-shopping-cart']/parent::button")
	public static WebElement cart;
	
}
