package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class loginproperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		Properties properties = new Properties();
		properties.load(new FileInputStream(".\\src\\test\\java\\properties\\locators.properties"));
		
		//System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://letcode.in/signin");
		//driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("email")).sendKeys(properties.getProperty("email"));
		driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
		driver.findElement(By.xpath("//button[.='LOGIN']")).click();

	}

}
