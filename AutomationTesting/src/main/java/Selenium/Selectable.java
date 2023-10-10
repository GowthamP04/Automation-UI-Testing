package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		List<WebElement> selectable = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		int size = selectable.size();
		System.out.println(size);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1))
		.click(selectable.get(2)).click(selectable.get(3));
//		action.clickAndHold(selectable.get(0));
//		action.clickAndHold(selectable.get(1));
//		action.clickAndHold(selectable.get(2));
//		action.clickAndHold(selectable.get(3));
//		action.clickAndHold(selectable.get(4));
		action.build().perform();
		driver.quit();

	}

}
