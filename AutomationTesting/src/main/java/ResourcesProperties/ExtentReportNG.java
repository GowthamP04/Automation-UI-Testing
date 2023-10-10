package ResourcesProperties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gowtham");
		return extent;
	}
}
