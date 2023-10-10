package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateElementPageObject {

	@FindBy(id="testing")
	public static WebElement work;
	
	@FindBy(xpath="//a[text()='Edit']")
	public static WebElement input;
	
	@FindBy(id="fullName")
	public static WebElement name;
	
	@FindBy(id="join")
	public static WebElement text;
	
	@FindBy(id="getMe")
	 public static WebElement textbox;
	 
	@FindBy(id="clearMe")
	 public static WebElement clear;
	 
	 
	
//	public static WebElement work(WebDriver driver) {
//		return driver.findElement(By.id("testing"));
//	}
//	public static WebElement input(WebDriver driver) {
//		return driver.findElement(By.xpath("//a[text()='Edit']"));
//	}
//   public static WebElement name(WebDriver driver) {
//	   return driver.findElement(By.id("fullName"));
//	}
//   public static WebElement text(WebDriver driver) {
//	   return driver.findElement(By.id("join"));
//    }
//   public static WebElement textbox(WebDriver driver) {
//	   return driver.findElement(By.id("getMe"));
//    }
//   public static WebElement clear(WebDriver driver) {
//	   return driver.findElement(By.id("clearMe"));
//	}

}
