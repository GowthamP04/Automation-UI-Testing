package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {  //constructor
		
		super(driver);
		this.driver=driver;   //this.driver is landingpage driver and another driver is webdriver driver calling to another package of newframework
	PageFactory.initElements(driver, this);
	}
	//WebElement email=driver.findElement(By.id("userEmail"));
	
	@FindBy(id = "userEmail")
	WebElement emailID;
	
	@FindBy(id = "userPassword")
	WebElement passwords;
	
	@FindBy(id = "login")
	WebElement submitbtn;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email, String password) {
		
		emailID.sendKeys(email);
		passwords.sendKeys(password);
		submitbtn.click();
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public WebElement getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		errorMessage.getText();
		return errorMessage;
	}
	 public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
}
