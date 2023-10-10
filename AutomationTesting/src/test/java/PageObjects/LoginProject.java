package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginProject {

	@FindBy(id = "userEmail")
	public static WebElement login;
	
	@FindBy(id = "userPassword")
	public static WebElement password;
	
	@FindBy(id = "login")
	public static WebElement loginbtn;
	
	
}
