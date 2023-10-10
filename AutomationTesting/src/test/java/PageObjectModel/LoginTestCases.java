package PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.LoginPageObject;

public class LoginTestCases {
@Test
	public  void main() {
	
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 	WebDriver driver = new ChromeDriver();
		 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("https://letcode.in/signin");
		    
		    PageFactory.initElements(driver, LoginPageObject.class);
		    
		    LoginPageObject.username.sendKeys("koushik350@gmail.com");
		    LoginPageObject.password.sendKeys("Pass123$");
		    LoginPageObject.loginbtn.click();
		    
		    
		    //LoginPageObject loginpageobject = new LoginPageObject();
			/*
			 * LoginPageObject.username(driver).sendKeys("koushik350@gmail.com");
			 * LoginPageObject.password(driver).sendKeys("Pass123$");
			 * LoginPageObject.loginbtn(driver).click();
			 */
		   
		   
			
		    
		    
		    /*
			 * System.out.println(driver.getCurrentUrl());
			 * System.out.println(driver.getTitle()); WebElement login =
			 * driver.findElement(By.linkText("Log in")); login.click(); WebElement username
			 * = driver.findElement(By.name("email"));
			 * username.sendKeys("koushik350@gmail.com"); WebElement password =
			 * driver.findElement(By.name("password")); password.sendKeys("Pass123$");
			 * WebElement loginbtn =
			 * driver.findElement(By.xpath("//button[text()='LOGIN']")); loginbtn.click();
			 * driver.quit();
			 */
			
			
			

	}

}
