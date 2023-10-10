package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.LoginProjectPageObject;

public class BrowserTest // extends LoginProjectPageObject
{

	public WebDriver driver;
	
	@BeforeTest 
	public void launchbrowser() throws InterruptedException {
		
	 	 driver = new EdgeDriver();
 	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	driver.get("https://rahulshettyacademy.com/client");

	}
	
	@Test	// (priority = 1)
	public void test() throws InterruptedException {
			//System.out.println(driver.getCurrentUrl());
	 	LoginProjectPageObject obj=new LoginProjectPageObject();
	 	obj.main(driver);
	}
	
	

 	@AfterTest
	public void endbrowser() {
 	driver.quit();
}
}