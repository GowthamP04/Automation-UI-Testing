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
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.sun.net.httpserver.Authenticator.Retry;

import Framework.CartPage;
import Framework.CheckOutPage;
import Framework.ConfirmMessagePage;
import Framework.LandingPage;
import Framework.ProductCatalogue;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {
	
		
		String productName = "ZARA COAT 3";

		 landingpage.loginApplication("anshika@gmail.com","Iamking@0");
		
		org.testng.Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	@Test //(groups = {"ErrorHandling"})
	public void productErrorValidation() throws IOException, InterruptedException {
	
		
		String productName = "ZARA COAT 3";

		ProductCatalogue productcatalogue = landingpage.loginApplication("rahulshetty@gmail.com","Iamking@000");
		
		
		List<WebElement> products = productcatalogue.getProductlist();
		
		productcatalogue.addProductToCart(productName);
		
		CartPage cartpage = productcatalogue.goToCart();
		
		boolean  match = cartpage.verifyProductDisplay("ZARA COAT 33");
		org.testng.Assert.assertFalse(match);
}
}




