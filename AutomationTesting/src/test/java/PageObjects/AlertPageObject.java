package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPageObject {

	@FindBy(linkText = "Dialog")
	public static WebElement alert;
	
	@FindBy(id = "accept")
	public static WebElement simple;
	
	@FindBy(id = "confirm")
	public static WebElement confirm;
	
	@FindBy(id = "prompt")
	public static WebElement prompt;
	

}
