package ExtentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {

	com.aventstack.extentreports.ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		//com.aventstack.extentreports.ExtentReports 
		extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gowtham");
		
	}
	
	@Test
	public void initialTest() {
		
		ExtentTest test = extent.createTest("Initial Test");
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		//test.fail("result do not match");  --->failed case
		driver.quit();
		extent.flush();
		
	}
}
