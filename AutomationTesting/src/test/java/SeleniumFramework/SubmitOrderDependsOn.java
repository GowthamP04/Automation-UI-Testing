package SeleniumFramework;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import Framework.CartPage;
import Framework.CheckOutPage;
import Framework.ConfirmMessagePage;
import Framework.LandingPage;
import Framework.OrdersPage;
import Framework.ProductCatalogue;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderDependsOn extends BaseTest {

	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrderTest() throws IOException, InterruptedException {
	//public static void main(String[] args) throws InterruptedException {
		
		

		ProductCatalogue productcatalogue = landingpage.loginApplication("anshika@gmail.com","Iamking@000");
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		
		List<WebElement> products = productcatalogue.getProductlist();
		
		productcatalogue.addProductToCart(productName);
		
		CartPage cartpage = productcatalogue.goToCart();
		//CartPage cartpage = new CartPage(driver);
		
		boolean  match = cartpage.verifyProductDisplay(productName);
		org.testng.Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOutPage();
		
		//CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.SelectCountryPage("india");
		ConfirmMessagePage confirmmessage = checkoutpage.submitOrder();
		
		//ConfirmMessagePage confirmmessage = new ConfirmMessagePage(driver);
		
		String confirmMessage =confirmmessage.getCofirmationMessage();
		org.testng.Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.quit();
	}
	
	
	@Test(dependsOnMethods = {"submitOrderTest"})
	public void orderHistoryPage() {
		
		ProductCatalogue productcatalogue = landingpage.loginApplication("anshika@gmail.com","Iamking@000");
		OrdersPage orderpage = productcatalogue.goToOrderpage();
		org.testng.Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
		
	}
}





