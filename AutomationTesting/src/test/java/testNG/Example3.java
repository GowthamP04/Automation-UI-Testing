package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example3 {
@Test
	public  void main() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		//driver.findElement(By.name("input")).sendKeys("cricket" + Keys.ENTER);
		driver.get("https://www.google.com/search?q=cricket&rlz=1C1CHZN_enIN1034IN1034&oq=cr&aqs=chrome.0.69i59j69i57j0i271l3.5059j0j7&sourceid=chrome&ie=UTF-8");
		List<WebElement> cricket = driver.findElements(By.xpath("//*[contains(text(),'cricket') or contains(text(),'Cricket')]"));
        System.out.println(cricket.size());
        driver.quit();
	}

}
