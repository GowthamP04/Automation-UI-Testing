package Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	@Parameters({"emailID" , "password"})
@Test
	public void main(String email , String pass) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://letcode.in/");
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.name("email")).sendKeys(email);
	driver.findElement(By.name("password")).sendKeys(pass);
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	driver.quit();
	
	

	}

}
