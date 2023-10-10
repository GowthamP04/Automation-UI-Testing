package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.get("https://letcode.in/alert");
WebElement simplealert = driver.findElement(By.id("accept"));
simplealert.click();
Alert alert = driver.switchTo().alert();
String text=alert.getText();
System.out.println(text);
alert.accept();
WebElement confirmbutton = driver.findElement(By.id("confirm"));
confirmbutton.click();
Alert confirmalert = driver.switchTo().alert();
confirmalert.dismiss();
WebElement promptbutton = driver.findElement(By.id("prompt"));
promptbutton.click();
Alert promptalert = driver.switchTo().alert();
promptalert.sendKeys("welcome to gowtham");
promptalert.accept();
WebElement name = driver.findElement(By.id("myName"));
String myname = name.getText();
System.out.println(myname);
driver.quit();
}

}
