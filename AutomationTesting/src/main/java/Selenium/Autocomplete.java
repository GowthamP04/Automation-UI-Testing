package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/autocomplete/");
		driver.switchTo().frame(0);
		WebElement input = driver.findElement(By.id("tags"));
		input.sendKeys("a");
		
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		int size = options.size();
		System.out.println(size);
		for (WebElement webelement : options) {
			if(webelement.getText().equals("Java")) {
			webelement.click();
			break;
		}
driver.quit();
	}

	}
	}
