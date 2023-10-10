package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrogBy {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		action.dragAndDropBy(ele, x+100, y+120).build().perform();
		
		
	}

}
