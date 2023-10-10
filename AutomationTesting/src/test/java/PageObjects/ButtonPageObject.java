package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonPageObject {
	
	@FindBy(xpath = "//a[text()='Click']")
	public static WebElement button;

	@FindBy(id = "position")
	public static WebElement Coordinates;
	
	@FindBy(id = "color")
	public static WebElement color;
	
	@FindBy(id = "property")
	public static WebElement heightwidth;
}
