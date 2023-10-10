package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class buyNow {

	
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[2]")
	public static WebElement buynow;

}
