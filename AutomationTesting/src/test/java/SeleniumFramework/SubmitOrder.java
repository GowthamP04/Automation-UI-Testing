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
import Framework.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {

	@Test //(retryAnalyzer = Retry.class)  //--->retryanalyzer rerun the failed selenium tests
	public void submitOrderTest() throws IOException, InterruptedException {
	//public static void main(String[] args) throws InterruptedException {
		
		String productName = "ZARA COAT 3";
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.get("https://rahulshettyacademy.com/client");
		//LandingPage landingpage =launchApplication();
//		LandingPage landingpage = new LandingPage(driver);
//		landingpage.goTo();
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
}






		//driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		//driver.findElement(By.id("login")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	//	WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b"))
//				.getText().equals(productName)).findFirst().orElse(null);
//		
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		//boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
		//org.testng.Assert.assertTrue(match);
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//Actions a = new Actions(driver);
		
		//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		//driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		//org.testng.Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.quit();
	//}

//}
