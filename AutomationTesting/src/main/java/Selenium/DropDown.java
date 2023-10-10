package Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement fruits = driver.findElement(By.id("fruits"));
		Select select = new Select(fruits);
		boolean issel = select.isMultiple();
		System.out.println(issel);
		List<WebElement> allopt = select.getOptions();
		//allopt.forEach(i -> System.out.println(i.getText()));
		select.selectByVisibleText("Apple");
		String fru = driver.findElement(By.className("subtitle")).getText();
		System.out.println(fru);
		WebElement country = driver.findElement(By.id("country"));
		Select mycountry = new Select(country);
		mycountry.selectByValue("India");
		WebElement ele = mycountry.getFirstSelectedOption();
		System.out.println(ele.getText());
		WebElement heros = driver.findElement(By.id("superheros"));
		Select myheros = new Select(heros);
		boolean ismul = myheros.isMultiple();
		System.out.println("is multiple selected :"+ismul);
		myheros.selectByIndex(2);
		myheros.selectByIndex(3);
		myheros.selectByIndex(6);
		myheros.selectByIndex(22);
		List<WebElement> allheros = myheros.getAllSelectedOptions();
		for(WebElement webelement : allheros) {
			System.out.println(webelement.getText());
			
		}
			
		}
			
		

	}


