package ExcelSheetDataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.read.biff.BiffException;

public class ExcelDataProvider {

	String[][] data =null;
	
	//WebDriver  driver;
	
	@DataProvider(name="logincredentials")
	public String[][] loginDataProvider() throws BiffException, IOException {
		
		data = getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException {
		
		FileInputStream excel = new FileInputStream("excel file path..");
		
		jxl.Workbook workbook = jxl.Workbook.getWorkbook(excel);
		
		Sheet sheet = workbook.getSheet(0);
		
		int rowcount = sheet.getRows(); // rowcount =5
		int columncount = sheet.getColumns(); //columncount =2
		
		String testData[][] = new String[rowcount-1][columncount]; // we should remove the header value in row
		
		for(int i=1; i<rowcount; i++) {
			for(int j=0; j<columncount; j++) {
				 testData[i-1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
		
	}
	
//	@BeforeTest
//	public void beforeTest() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		  driver = new ChromeDriver();
//	}
	
//	@AfterTest
//	public void afterTest() {
//		
//		driver.quit();
//	}
	
	
@Test (dataProvider = "logincredentials")
public void main(String user,String pass) throws InterruptedException
{
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver  driver = new ChromeDriver();

driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Thread.sleep(5000);
WebElement username = driver.findElement(By.name("username"));
username.sendKeys(user);
//Thread.sleep(5000);
WebElement password = driver.findElement(By.name("password"));
password.sendKeys(pass);
//Thread.sleep(5000);
WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
loginbtn.click();

driver.quit();
}

}


