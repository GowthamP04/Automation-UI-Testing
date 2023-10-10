package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {  //constructor
	
		super(driver);
		this.driver=driver;   //this.driver is ProductCatalogue driver and another driver is webdriver driver calling to another package of newframework
	PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement DisAppearMessage;
	
	By product = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductlist() {
		
		waitForElementToAppear(product);
		return products;
	}

	public WebElement getProductName(String productName) {
		
		WebElement prod = getProductlist().stream().filter(product -> product.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod = getProductName(productName);   //prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(DisAppearMessage);
	}
}
