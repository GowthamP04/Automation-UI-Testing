package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class downloadOrder {

	
	@FindBy(xpath = "//button[text()='Click To Download Order Details in Excel']")
	public static WebElement downloadorder;
}
