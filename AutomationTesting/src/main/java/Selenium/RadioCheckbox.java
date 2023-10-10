package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[text()='Toggle']")).click();
	    driver.findElement(By.id("yes")).click();
	    driver.findElement(By.id("two")).click();
	    WebElement bug = driver.findElement(By.id("bug"));
	    bug.click();
	    WebElement first = driver.findElement(By.id("foo"));
	    //first.click();
	    if(first.isSelected()) {
	    	first.click();
	    }
	    WebElement second = driver.findElement(By.id("notfoo"));
	    if(second.isSelected()) {
	    	second.click();
	    }
//	    boolean select = bar.isSelected();
//	    System.out.println("bar is :"+select);
	 
	    WebElement disabled = driver.findElement(By.id("maybe"));
	    boolean en = disabled.isEnabled();
	    System.out.println("maybe field is disabled :"+en);
	    WebElement remember = driver.findElement(By.xpath("//*[text()=' Remember me ']"));
	    boolean rem  = remember.isSelected();
	    System.out.println(rem);
	    driver.findElement(By.linkText("FAKE terms and conditions")).click();
	    driver.quit();
	    
	    
	}
}

	


