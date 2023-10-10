package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Menu']")).click();
		driver.switchTo().frame(0);
//		WebElement ele = driver.findElement(By.id("ui-id-4"));
//		Actions action = new Actions(driver);
//		action.moveToElement(ele).build().perform();
//		
		Actions action = new Actions(driver);
		WebElement music = driver.findElement(By.id("ui-id-9"));
		//*[@id="ui-id-13"]
		action.moveToElement(music).build().perform();
		
		WebElement rock = driver.findElement(By.id("ui-id-10"));
		//ui-id-15
		//rock.click();
		action.moveToElement(rock).build().perform();
		WebElement select = driver.findElement(By.xpath("//div[contains(text(),'Alternative')]"));
		System.out.println(select.getText());
		select.click();
		
		//WebElement clk = driver.findElement(By.id("ui-id-10"));
		
		//action.click().build().perform();
		
		
		//action.moveToElement(rock).build().perform();
	//clk.click();
		
		
		
//		driver.findElement(By.xpath("//button[.='✕']")).click();
//		WebElement elec = driver.findElement(By.className("xtXmba"));
//		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/a/div[2]")).click();
//		//WebElement elec = driver.findElement(By.xpath("//span[.='Electronics']"));
//		//WebElement elec = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[1]"));
//		Actions action = new Actions(driver);
//		action.moveToElement(elec).build().perform();
//		//driver.findElement(By.linkText("Realme")).click();
//		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		
		
		
		

	}

}
