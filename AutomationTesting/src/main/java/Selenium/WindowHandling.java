package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://letcode.in/windows");
		String windowhandle = driver.getWindowHandle();
		String cur1 = driver.getCurrentUrl();
		System.out.println(cur1);
		driver.findElement(By.id("home")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowhandles);
		driver.switchTo().window(list.get(1));
		String cur2 = driver.getCurrentUrl();
		System.out.println(cur2);
		driver.findElement(By.linkText("Drop-Down")).click();
		WebElement lang = driver.findElement(By.id("lang"));
		Select select = new Select(lang);
		select.selectByValue("java");
		WebElement fir = select.getFirstSelectedOption();
		System.out.println(fir.getText());
		WebElement java = driver.findElement(By.className("subtitle"));
		System.out.println(java.getText());
		driver.close();
		Set<String> windowhandles2 = driver.getWindowHandles();
		list.clear();
		list.addAll(windowhandles2);
		driver.switchTo().window(list.get(0));
		String cur3 = driver.getCurrentUrl();
		System.out.println(cur3);
		WebElement multi = driver.findElement(By.id("multi"));
		multi.click();
		int totalwindow = driver.getWindowHandles().size();
		System.out.println("totalwindows: "+totalwindow);
		Set<String> newwindows  = driver.getWindowHandles();
		for (String allwindow : newwindows) {
			if(!allwindow.equals(windowhandle)) {
				driver.switchTo().window(allwindow);
				driver.close();
			}
		}
		driver.quit();
		//List<WebElement> allname = driver.findElements(By.xpath("//div[@class='block']"));
		//for (WebElement name : allname) {
			//String names  = name.getText();
			//System.out.println(names);
		}

	}


