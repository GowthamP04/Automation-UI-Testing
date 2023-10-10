package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectProduct {

	@FindBy(xpath = "//*[@id=\"products\"]/div[1]/div[2]/div[3]/div/div/button[1]")
	public static WebElement view;
	
}
