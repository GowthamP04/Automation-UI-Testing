package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addToCard {

	
	@FindBy(xpath = "//button[text()='Add to Cart']")
	public static WebElement addtocard;
}
