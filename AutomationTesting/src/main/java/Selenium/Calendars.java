package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendars {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.switchTo().frame(0);
	WebElement calendars = driver.findElement(By.id("datepicker"));
//	calendars.sendKeys("07/22/2023"+Keys.ENTER);
	calendars.click();
	
	WebElement next = driver.findElement(By.xpath("//a[@title='Next']"));
	next.click();
	WebElement date = driver.findElement(By.xpath("//a[contains(text(),'15')]"));
	date.click();
	String text = date.getText();
	System.out.println(text);
	driver.quit();
	}

}
