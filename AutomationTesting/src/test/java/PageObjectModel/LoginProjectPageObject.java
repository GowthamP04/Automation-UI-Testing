package PageObjectModel;

import java.io.File;

//import java.io.File;

import java.time.Duration;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.BrowserTest;
import PageObjects.Cart;
import PageObjects.LoginProject;
import PageObjects.SelectProduct;
import PageObjects.addToCard;
import PageObjects.buyNow;
import PageObjects.downloadOrder;
import PageObjects.historyPage;
import PageObjects.personalDetails;

public class LoginProjectPageObject{

@Test

	public void main(WebDriver driver) throws InterruptedException  {
	
		
//		  System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
//		  WebDriver driver = new EdgeDriver(); driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		  WebDriverWait wait;
		  
		  
		//  driver.get("https://rahulshettyacademy.com/client");
		 
	    //this.driver=driver;
	    PageFactory.initElements(driver, LoginProject.class);
	    LoginProject.login.sendKeys("anshika@gmail.com");
	    LoginProject.password.sendKeys("Iamking@000");
	    LoginProject.loginbtn.click();
	    
	    PageFactory.initElements(driver, SelectProduct.class);
	    SelectProduct.view.click();
	    
	    PageFactory.initElements(driver, addToCard.class);
	    addToCard.addtocard.click();
	    
	   PageFactory.initElements(driver, Cart.class);
	   Cart.cart.click();
	   
	   PageFactory.initElements(driver, buyNow.class);
	   buyNow.buynow.click();
	   
	   PageFactory.initElements(driver, personalDetails.class);
	   String cart=personalDetails.CreditCardNumber.getAttribute("value");
	   System.out.println(cart);
	  
	   Select select=new Select( personalDetails.ExpiryfromDate);
	   select.selectByVisibleText("08");
	   
	   Select select1=new Select( personalDetails.ExpirytoDate);
	   select1.selectByVisibleText("16");
	 
	   personalDetails.CVVCode.sendKeys("1234");
	   personalDetails.NameonCard.sendKeys("234567");
	   
	  
	   //personalDetails.selectcountry(driver).sendKeys("ind");
	   personalDetails.selectcoun.sendKeys("ind");
	   int i=personalDetails.selectcountry.size();
	   System.out.println(i);
	   
	   List<WebElement> option=personalDetails.selectcountry;
	  for (WebElement webElement : option) {
		  if(webElement.getText().trim().equalsIgnoreCase("india")) {
			  webElement.click();
			  break;
		  }
	}
	  System.out.println("Element is clicked ");
	 Thread.sleep(2000);
	 //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//  WebDriverWait wait = new WebDriverWait(driver,30);
	//  WebDriverWait wait=new WebDriverWait(driver, 20);
	 personalDetails.placeorder.click();
	 
	System.out.println("Element is clicked ");
	 
	 PageFactory.initElements(driver, historyPage.class);
	 historyPage.historytab.click();
	 
	 driver.navigate().back();
	 
	 PageFactory.initElements(driver, downloadOrder.class);
	 downloadOrder.downloadorder.click();
	 
	 File filelocation = new File("C:\\Users\\GO20382992\\Downloads");
	 File[] totalfiles=filelocation.listFiles();
	 for (File file : totalfiles) {
		if(file.getName().contains("order-invoice_anshika")) {
			System.out.println("file is downloaded");
			break;
		}
	}
	 Thread.sleep(5000);
	 personalDetails.signout.click();
	// driver.quit();
	}
}
