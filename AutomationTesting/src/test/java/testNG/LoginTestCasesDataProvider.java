package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestCasesDataProvider {
	//WebDriver driver;
	@DataProvider(name="logincredentials")
public String[][] loginpage() {
	String[][] data = {
			{"Admin","admin1"},         //crt user, wrong pass
			{"admin","admin123"},       //wrong pass.crt user
			{"Admin","admin123"},       //crt user, crt pass
			{"admin","admin1"},         //wrong user, wrong pass
	};
	return data;
}
//	
//	@BeforeTest
//	public void beforetest() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		  driver = new ChromeDriver();
//	}
//	@AfterTest
//	public void aftertest() {
//		driver.quit();
//	}
	
	@Test (dataProvider = "logincredentials")
	public void main(String user,String pass) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
   
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //Thread.sleep(5000);
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys(user);
    //Thread.sleep(5000);
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys(pass);
    //Thread.sleep(5000);
    WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
    loginbtn.click();
    
   driver.quit();
	}

}
