package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
	//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriverManager.edgedriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.get("https://letcode.in/signin");
	//driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.name("email")).sendKeys("koushik350@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Pass123$");
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	
	
	

	}

}
