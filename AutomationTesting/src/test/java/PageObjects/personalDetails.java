package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class personalDetails {

	@FindBy(xpath = "//input[@type='text' and @class='input txt text-validated']")
	public static WebElement CreditCardNumber;
	
	@FindBy(xpath = "//select[@class='input ddl'][1]")
	public static WebElement ExpiryfromDate;
	
	@FindBy(xpath = "//select[@class='input ddl'][2]")
	public static WebElement ExpirytoDate;
	
	@FindBy(xpath = "//input[@class='input txt'][1]")
	public static WebElement CVVCode;
	
	@FindBy(xpath = "(//input[@type='text' and @class='input txt'])[2]")
	public static WebElement NameonCard;
	
//	public static WebElement selectcountry(WebDriver driver) {
//		return driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
//		}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	public static WebElement selectcoun;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']/following::button")
	public static List<WebElement> selectcountry;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	public static WebElement placeorder;
	
	@FindBy(xpath = "//*[text()=' Sign Out ']")
	public static WebElement signout;
}
