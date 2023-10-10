package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

	WebDriver driver;
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extents;
    ExtentTest testcase;
	
    
	@Test
	public void OpenGoogle() {
		testcase=extents.createTest("verify Google title");
		driver.get("https://www.google.co.in");
		String title=driver.getTitle();
		if(title.equals("Google")) {
			//
		}else {
			//
		}
	}

	private ExtentTest createTest(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void OpenBing() {
		testcase=extents.createTest("verify bing title");
		driver.get("https://www.bing.com");
		String title=driver.getTitle();
		if(title.equals("Bing")) {
			//
		}else {
			//
		}
	}
		

//	@Test
//	public void OpenYahoo() {
//		testcase=extents.createTest("verify yahoo title");
//		driver.get("https://www.yahoo.com");
//		String title=driver.getTitle();
//		if(title.equals("Yahoo")) {
//			//
//		}else {
//			//
//		}
//		
	//}
	@BeforeSuite
	public void launchBrowser() {
		
		sparkReporter = new ExtentSparkReporter("./ExtentReport.html");
		extents = new ExtentReports();
		extents.attachReporter(sparkReporter);
		
		driver = new ChromeDriver();
		
	}
	public void attachReporter(ExtentSparkReporter sparkReporter2) {
		// TODO Auto-generated method stub
		
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		extents.flush();
	}

	public void flush() {
		// TODO Auto-generated method stub
	
	
}
}


