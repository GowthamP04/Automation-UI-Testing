package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.CartPage;
import Framework.OrdersPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {    //constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartheader;
	

	@FindBy(css = "[routerlink*='myorders']") //-->orders to dependson concept
	WebElement ordersheader;
	
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));  //-->By.cssSelector(".mb-3")	
}
	
	public void waitForWebElementToAppear(WebElement findBy) {  //-->errorvalidation fields
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));  	
	}
	
	public CartPage goToCart() {
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); --> this element is common field that's why we can write a default this abstract package
		cartheader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	}
	
	
	public OrdersPage goToOrderpage() {
		ordersheader.click();
		OrdersPage orderpage = new OrdersPage(driver);
		return orderpage;
		
	}
	public void waitForElementToDisAppear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);  //everyone attendtime login the url that time over load is not accepting so we should give thread.sleep 
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele)); //->(driver.findElement(By.cssSelector(".ng-animating")))
	}
}

