package Selenium;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println("button page url :"+ url);
		driver.findElement(By.id("home")).click();
		Thread.sleep(3000);
		String url1 = driver.getCurrentUrl();
		System.out.println("home page url :"+ url1);
		driver.navigate().back();
		WebElement positionbutton = driver.findElement(By.id("position"));
		org.openqa.selenium.Point point = positionbutton.getLocation();	
		int x = point.getX();
		int y = point.getY();
		System.out.println("x value is: "+ x + "y value is: "+y);
		WebElement colorbutton = driver.findElement(By.id("color"));
		String color = colorbutton.getCssValue("background-color");
		System.out.println(color);
		WebElement sizebutton = driver.findElement(By.id("property"));
		int height = sizebutton.getSize().getHeight();
		int width  = sizebutton.getSize().getWidth();
		System.out.println("Height is: "+ height + "Width is: "+width);
		WebElement enabled = driver.findElement(By.id("isDisabled"));
		boolean en = enabled.isEnabled();
		System.out.println(en);
		driver.quit();
		

	}

}
