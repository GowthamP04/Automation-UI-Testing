package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationExtentReports {

	public static void main(String[] args) {
		ExtentSparkReporter repoeter = new ExtentSparkReporter("./TestReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(repoeter);
		ExtentTest test = extent.createTest("TC001 - Login");
		test.assignAuthor("gowtham");
		test.assignCategory("sanity testing");
		test.pass("verify the emailid");
		test.pass("verify the passwod");
		test.pass("verify the login btn");
		
		ExtentTest test2 = extent.createTest("TC002 - payment");
		test2.pass("navigate to payment");
		test2.fail("payment failed",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/img.png").build());
		
		extent.flush();
	}

}
