package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css = ".cartSection h3")
	 List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	 WebElement cartPage;
	
	public boolean verifyProductDisplay(String productName) {
		
		boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOutPage() {
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		cartPage.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
}
