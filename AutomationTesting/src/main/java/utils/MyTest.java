package utils;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends Reports {
	@BeforeTest
	void setdata() {
		desc="first test";
		author="gowtham";
		category="reg";
	}
@Test
	public void mytest(){
		System.out.println("start test");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("email")).sendKeys("koushik350@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass123$");
		driver.findElement(By.xpath("//button[.='LOGIN']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		stepreport("pass","some description");
	}
}
