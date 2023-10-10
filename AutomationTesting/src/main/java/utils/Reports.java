package utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	ExtentReports extent;
	ExtentTest test;
	String desc="";
	String author="";
	String category="";
	@BeforeSuite
	protected void startreport() {
		ExtentSparkReporter repoeter = new ExtentSparkReporter("./TestReports.html");
	     extent = new ExtentReports();
		extent.attachReporter(repoeter);
	}
	@AfterSuite
	protected void stopreport() {
		extent.flush();
	}
	@BeforeClass
	void createtest() {
		    test = extent.createTest(desc);
			test.assignAuthor(author);
			test.assignCategory(category);
	}
	void stepreport(String status, String description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		case "info":
			test.info(description);
			break;
		case "warning":
			test.warning(description);
			break;

		default:
			System.err.println("status is not defined");
			break;
		}
	}
	}


