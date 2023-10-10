package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	//public static final WebDriver driver = null;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.get("https://letcode.in/waits");
		driver.findElement(By.id("accept")).click();
		
		//FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert until = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(until.getText());
		until.accept();
		
		driver.get("https://letcode.in/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("email")).sendKeys("koushik350@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass123$");
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@role='alertdialog']"));
		wait.until(ExpectedConditions.visibilityOf(msg));
		System.out.println(msg.getText());
		wait.until(ExpectedConditions.invisibilityOf(msg));
		driver.findElement(By.linkText("Sign out")).click();
		driver.quit();
	

	}

}
