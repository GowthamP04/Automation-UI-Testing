package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Framework.CartPage;
import Framework.CheckOutPage;
import Framework.ConfirmMessagePage;
import Framework.LandingPage;
import Framework.ProductCatalogue;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest{

	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public ConfirmMessagePage confirmmessage;
	
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		 landingpage =launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")  //--(.+)replace to <name> and <password> 
	public void logged_in_username_and_password(String username, String password) {
		 productcatalogue = landingpage.loginApplication(username,password);
	}
	
	@When ("^I add product (.+) to cart$")  //--(.+) replace to <productName>
	public void i_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productcatalogue.getProductlist();
		productcatalogue.addProductToCart(productName);
	}
	
	@And ("^CheckOut (.+) and Submit the order$")  //--(.+) replace to <productName>
	public void checkout_and_submit_the_order(String productName) {
		CartPage cartpage = productcatalogue.goToCart();
		boolean  match = cartpage.verifyProductDisplay(productName);
		org.testng.Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOutPage();
		checkoutpage.SelectCountryPage("india");
		 confirmmessage = checkoutpage.submitOrder();
	}

	@Then ("{string} message is displayed on confirmation Page") //{string} replace to THANKYOU FOR THE ORDER.
	public void message_is_displayed_on_confirmation_page(String string) {
		String confirmMessage =confirmmessage.getCofirmationMessage();
		org.testng.Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.quit();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		org.testng.Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		driver.quit();
	}
}
