package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://petstore.octoperf.com/");
		driver.manage().window().maximize();
		WebElement store = driver.findElement(By.linkText("Enter the Store"));
		store.click();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("username")).sendKeys("j2ee");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("j2ee");
		driver.findElement(By.name("signon")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("password")).sendKeys("j2ee");
		driver.findElement(By.name("repeatedPassword")).sendKeys("j2ee");
		driver.findElement(By.name("editAccount")).click();
		driver.findElement(By.linkText("My Orders")).click();
		//Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		

	}

}
