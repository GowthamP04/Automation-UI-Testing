package Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	private static final By ByTagName = null;
	private static Object i;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/table");
		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> headers = table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			String text = header.getText();
			System.out.println(text);
		}
			List<WebElement> allrows =  table.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
			int size = allrows.size();
			System.out.println(size);
			/*for (WebElement row : allrows) {
		  List<WebElement> column =	row.findElements(By.tagName("td"));
		  WebElement firstcol =  column.get(0);
				System.out.println(firstcol.getText());
			}*/
			for(int i=0; i<size; i++) {
				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				WebElement tworow =	rows.get(1);
				String text = tworow.getText();
				System.out.println(text);
					if(text.equals("Man")) {
						WebElement input = rows.get(3).findElement(By.tagName("input"));
						input.click();
						break;
				}
					
				}
			}
			
		}
		
		

	



