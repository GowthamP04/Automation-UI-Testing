package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Textbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		driver.findElement(By.id("fullName")).sendKeys("gowtham");
		driver.findElement(By.id("join")).sendKeys(" person" + Keys.ENTER);
		String value = driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(value);
		driver.findElement(By.id("clearMe")).clear();
		boolean enabled = driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println(enabled);
		String readonly = driver.findElement(By.id("dontwrite")).getAttribute("value");
		System.out.println(readonly);
		
		
		
		

	}

}
