package Selenium;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SampleProject {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		WebElement radiobtn=driver.findElement(By.name("radioButton"));
		radiobtn.click();
		WebElement tooltip=driver.findElement(By.id("autocomplete"));
		String text=tooltip.getAttribute("placeholder");
		System.out.println(text);
		tooltip.sendKeys("ind");
		List<WebElement> option=driver.findElements(By.xpath("//input[@class='inputs ui-autocomplete-input']"));
		int size=option.size();
		System.out.println(size);
		for (WebElement webElement : option) {
			if(webElement.getText().equals("india")) {
				webElement.click();
				break;
			}
		}
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByValue("option2");
		WebElement opt=select.getFirstSelectedOption();
		System.out.println(opt.getText());
		//List<WebElement> checkbox=driver.findElements(By.xpath("//*[.='Checkbox Example']/following::label"));
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();
		String windowhandle=driver.getWindowHandle();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		driver.findElement(By.id("openwindow")).click();
		Set<String> windowhandles=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowhandles);
		driver.switchTo().window(list.get(1));
		String url2=driver.getCurrentUrl();
		System.out.println(url2);
		driver.close();
		Set<String> windowhandles2=driver.getWindowHandles();
		list.clear();
		list.addAll(windowhandles2);
		driver.switchTo().window(list.get(0));
		String url3=driver.getCurrentUrl();
		System.out.println(url3);
		driver.findElement(By.id("name")).sendKeys("hey");
		driver.findElement(By.id("alertbtn")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		WebElement table=driver.findElement(By.className("tableFixHead"));
		List<WebElement> header=table.findElements(By.tagName("th"));
		for (WebElement webElement : header) {
			System.out.println(webElement.getText());
		}
		List<WebElement> allrow=table.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[2]"));
		int n=allrow.size();
		System.out.println(n);
		for (WebElement row : allrow) {
			List<WebElement> column=	row.findElements(By.tagName("td"));
			WebElement cln=column.get(2);
			System.out.println(cln.getText());
		}
		WebElement mouse=driver.findElement(By.id("mousehover"));
		Actions action=new Actions(driver);
		action.moveToElement(mouse).build().perform();
		driver.findElement(By.linkText("Reload")).click();
		driver.quit();
		}
		}
		
		
		
		

	


