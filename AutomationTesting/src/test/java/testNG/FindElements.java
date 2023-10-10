package testNG;

import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElements {
@Test
	public  void main() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/edit");
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		for (WebElement label : labels) {
			String text = label.getText();
			System.out.println(text);
		}
			int size = labels.size();
			System.out.println(size);
			driver.quit();
		}


	}


