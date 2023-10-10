package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webelementandinteracting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		driver.switchTo().frame(0);
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='M6CB1c rr4y5c']")).click();
		//driver.switchTo().parentFrame();
		driver.findElement(By.id("input")).sendKeys("Karur" + Keys.ENTER);
	}

}
