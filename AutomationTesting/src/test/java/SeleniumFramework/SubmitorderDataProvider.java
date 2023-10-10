package SeleniumFramework;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
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

public class SubmitorderDataProvider extends BaseTest {

	//String productName = "ZARA COAT 3";
	
	@Test(dataProvider = "getData")
	public void submitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {
	//public static void main(String[] args) throws InterruptedException {
		//public void submitOrderTest(String email , String password , String productName) throws IOException, InterruptedException {	
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email") ,input.get("password"));
		//ProductCatalogue productcatalogue = landingpage.loginApplication(email ,password);
		
		
		List<WebElement> products = productcatalogue.getProductlist();
		
		productcatalogue.addProductToCart(input.get("productName"));
		//productcatalogue.addProductToCart(productName);
		CartPage cartpage = productcatalogue.goToCart();
		//CartPage cartpage = new CartPage(driver);
		
		boolean  match = cartpage.verifyProductDisplay(input.get("productName"));
		
		//boolean  match = cartpage.verifyProductDisplay(productName);
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
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\DataJson\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)} , {data.get(1)}};  //-->data for json file &create to list of hashmap concept
		
//		HashMap<String, String> map = new HashMap<String, String>(); //-->if we've execute 10 tc's dataprovider ah we just simply using for hashmap
//		map.put("email", "anshika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "rahulshetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ADIDAS ORIGINAL");
//		
		//return new Object[][] {{map} , {map1}};
		
		//return new Object[][] { {"anshika@gmail.com" ,"Iamking@000" ,"ZARA COAT 3"},
			//{"rahulshetty@gmail.com" ,"Iamking@000" ,"ADIDAS ORIGINAL"} };
	
	
	
	
	}
	
		
	}






