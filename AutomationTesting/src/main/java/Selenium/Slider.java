package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/slider/");
	driver.switchTo().frame(0);
	WebElement slider = driver.findElement(By.id("slider"));
	Actions action = new Actions(driver);
	action.moveToElement(slider, 50, 0).build().perform();
	slider.click();
	driver.quit();
	

	}

}
