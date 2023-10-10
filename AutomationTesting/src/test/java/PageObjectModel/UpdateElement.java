package PageObjectModel;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.AlertPageObject;
import PageObjects.ButtonPageObject;
import PageObjects.LoginPageObject;
import PageObjects.UpdateElementPageObject;


public class UpdateElement {
@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 	WebDriver driver = new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://letcode.in/signin");
	   
	    
	    PageFactory.initElements(driver, LoginPageObject.class);
	    
	    LoginPageObject.username.sendKeys("koushik350@gmail.com");
	    LoginPageObject.password.sendKeys("Pass123$");
	    LoginPageObject.loginbtn.click();
	    
	    Thread.sleep(5000);
	   PageFactory.initElements(driver, UpdateElementPageObject.class);
	    
	    UpdateElementPageObject.work.click();
	    UpdateElementPageObject.input.click();
	    UpdateElementPageObject.name.sendKeys("gowtham");
	    UpdateElementPageObject.text.sendKeys(" boy");
	    UpdateElementPageObject.textbox.getAttribute("value");
	    UpdateElementPageObject.clear.clear();
	    
	    driver.navigate().back();
	    //Thread.sleep(5000);
	    PageFactory.initElements(driver, ButtonPageObject.class);
	    ButtonPageObject.button.click();
	    int x= ButtonPageObject.Coordinates.getLocation().getX();
	    int y=ButtonPageObject.Coordinates.getLocation().getY();
	    System.out.println("x value is: "+ x + "y value is: "+y);
	    String color=ButtonPageObject.color.getCssValue("background-color");
	    System.out.println(color);
	    int height=ButtonPageObject.heightwidth.getSize().getHeight();
	    int width=ButtonPageObject.heightwidth.getSize().getWidth();
	    System.out.println("Height is: "+ height + "Width is: "+width);
	    driver.navigate().back();
	    
        PageFactory.initElements(driver, AlertPageObject.class);
        AlertPageObject.alert.click();
        AlertPageObject.simple.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        AlertPageObject.confirm.click();
        driver.switchTo().alert().accept();
        AlertPageObject.prompt.click();
        Alert prompt=driver.switchTo().alert();
        prompt.sendKeys("hey");
        prompt.accept();
       
        
	    
	    
		/*
		 * LoginPageObject.username(driver).sendKeys("koushik350@gmail.com");
		 * LoginPageObject.password(driver).sendKeys("Pass123$");
		 * LoginPageObject.loginbtn(driver).click();
		 *  Thread.sleep(5000);
		 * UpdateElementPageObject.work(driver).click();
		 * UpdateElementPageObject.input(driver).click();
		 * UpdateElementPageObject.name(driver).sendKeys("gowtham");
		 * UpdateElementPageObject.text(driver).sendKeys(" boy");
		 * UpdateElementPageObject.textbox(driver).getAttribute("value");
		 * UpdateElementPageObject.clear(driver).clear();
		 */
	    
	    
	    
	    
	    
	   /* System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getTitle());
		WebElement login = driver.findElement(By.linkText("Log in"));
		login.click();
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("koushik350@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Pass123$");
        WebElement loginbtn = driver.findElement(By.xpath("//button[text()='LOGIN']"));
        loginbtn.click();
        Thread.sleep(5000);
        
        WebElement work = driver.findElement(By.id("testing"));
        work.click();
        WebElement input = driver.findElement(By.xpath("//a[text()='Edit']"));
        input.click();
        WebElement name = driver.findElement(By.id("fullName"));
        name.sendKeys("gowtham");
        WebElement text = driver.findElement(By.id("join"));
        text.sendKeys(" boy");
        WebElement textbox = driver.findElement(By.id("getMe"));
        String value = textbox.getAttribute("value");
        System.out.println(value);
        WebElement clear = driver.findElement(By.id("clearMe"));
        clear.clear();
        driver.quit();
	}*/

	}
}
