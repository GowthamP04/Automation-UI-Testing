package testNG;
/*
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	@Parameters({"emailID" , "password"})
@Test
	public void main(String emailID,String password) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://letcode.in/");
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.name("email")).sendKeys(emailID);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	
	
	

	}

}
*/





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	RemoteWebDriver driver ;
	@Parameters({"emailID" , "password" , "browser"})
    @Test
	public void main(String emailID,String password , String browser) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	switch (browser) {
	case "chrome":
		driver = new ChromeDriver();
		break;
	case "edge":
		driver = new EdgeDriver();
		break;
		
	default:
		System.err.println("driver is not defined");
		break;
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://letcode.in/");
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.name("email")).sendKeys(emailID);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	
	}
}
	
	