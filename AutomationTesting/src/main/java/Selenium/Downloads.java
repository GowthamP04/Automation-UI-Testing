package Selenium;

import java.io.File;
//import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Downloads {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/file");
		WebElement download = driver.findElement(By.linkText("Download Pdf"));
		download.click();
		Thread.sleep(3000);
		File filelocation = new File("C:\\Users\\GO20382992\\Downloads");
		File[] totalfiles = filelocation.listFiles();
		for (File file : totalfiles) {
			if(file.getName().contains("sample")) {
				System.out.println("file is downloaded");
				break;
			}
		}
driver.quit();
	}

}
