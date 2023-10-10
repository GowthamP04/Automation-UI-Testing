package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		driver.switchTo().frame(0);
		driver.findElement(By.name("fname")).sendKeys("gowtham");
		driver.findElement(By.name("lname")).sendKeys("p");
		String name = driver.findElement(By.xpath("/html/body/app-root/app-frame-content/div/div/div[1]/p")).getText();
		System.out.println(name);
		driver.switchTo().frame(1);
		driver.findElement(By.name("email")).sendKeys("gowtham@gmail.com");
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("periyasamy");
		String fullname = driver.findElement(By.xpath("/html/body/app-root/app-frame-content/div/div/div[1]/p")).getText();
		System.out.println(fullname);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("/html/body/app-root/app-frames/section[1]/div/div/div[2]/app-learning-point/div/footer/a")).click();
	
	}

}
