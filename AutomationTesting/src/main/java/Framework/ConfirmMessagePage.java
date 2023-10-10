package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ConfirmMessagePage extends AbstractComponent{

	WebDriver driver;
	
	public ConfirmMessagePage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	 WebElement verifyMessage;
	
	public String getCofirmationMessage() {
		
		return verifyMessage.getText();
	}
}
