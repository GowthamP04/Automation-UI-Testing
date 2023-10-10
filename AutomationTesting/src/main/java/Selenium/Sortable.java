package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/sortable/");
	driver.switchTo().frame(0);
	List<WebElement> sortable = driver.findElements(By.xpath("//*[@id='sortable']/li"));
	int size = sortable.size();
	System.out.println(size);
	WebElement from = sortable.get(5);
	WebElement to = sortable.get(1);
	Actions action = new Actions(driver);
	action.clickAndHold(from);
	action.moveToElement(to);
	action.release(to);
	action.build().perform();
	//driver.quit();

	}

}
