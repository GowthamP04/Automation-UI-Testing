package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteTest {
	WebDriver driver;
	long starttime;
	long endtime;
	@BeforeSuite
	public void launchbrowser() {
	starttime = System.currentTimeMillis();
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
     driver = new ChromeDriver();
	}
	@Test
	public void chrome() {
		driver.get("https://www.google.co.in");
	}
	@Test
	public void bing() {
		driver.get("https://www.bing.com/");
	}
	@Test
	public void yahoo() {
		driver.get("https://www.yahoo.com/");
	}
	@AfterSuite
	public void endbrowser() {
		driver.quit();
		endtime= System.currentTimeMillis();
		long totaltime = endtime-starttime;
		System.out.println(totaltime);
	}
	
}
