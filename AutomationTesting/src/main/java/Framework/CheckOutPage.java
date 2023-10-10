package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	 WebElement country;
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	 WebElement selectcountry;
	
	@FindBy(css = ".action__submit")
	 WebElement submit;
	
	By results = By.cssSelector(".ta-results");

	public void SelectCountryPage(String countryName) {
	
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectcountry.click();	
}	
	
	 public ConfirmMessagePage submitOrder() {
		 
		 submit.click(); 
		 return new ConfirmMessagePage(driver);
	 }
}
