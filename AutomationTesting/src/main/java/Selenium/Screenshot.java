package Selenium;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://letcode.in/buttons");
File firstscr = driver.getScreenshotAs(OutputType.FILE);
File dest = new File("./snaps/img.png");
FileHandler.copy(firstscr, dest);
WebElement ele = driver.findElement(By.className("content"));
File elescr = ele.getScreenshotAs(OutputType.FILE);
File destele = new File("./snaps/img1.png");
FileHandler.copy(elescr, destele);

driver.quit();

	}

}



// File a=driver.getScreenshotAs(OutputType.FILE);
// File b=new File("./snaps/img2.png");
// FileHandler.copy(a, b); 
// driver.quit();
//	}
//}
 
 
