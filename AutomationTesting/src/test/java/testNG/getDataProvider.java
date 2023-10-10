package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.DataUtil;

public class getDataProvider  {
@DataProvider(name = "Login")
	public String[][] getData() {
		String[][] data = new String[2][2];
		data[0][0] = "koushik350@gmail.com";
		data[0][1] = "Pass123$";
		
		data[1][0] = "koushik1@letcode.in";
		data[1][1] = "Pass123$";
		
		return data;
	}
	
@Test(dataProvider = "Login")
	public void Login(String email , String pass) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://letcode.in/");
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.xpath("//button[.='LOGIN']")).click();
			String title = driver.getTitle();
			System.out.println(title);
			driver.quit();
	}
}

