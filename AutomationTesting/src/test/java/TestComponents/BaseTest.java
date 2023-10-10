package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework.LandingPage;
import SeleniumFramework.SubmitOrder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		//properties class
		Properties properties = new Properties();
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ResourcesProperties\\GlobalData.properties");
		properties.load(fileInput);
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
	
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			//chromedriver 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // those two lines common code, so that's why i'm not writing any if condition
		return driver;
	}
	
	//data for json file &create to list of hashmap concept
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		
		//resd json to string
		String jsoncontent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		
		//string to hashmap ->jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
	
	//screenshot utility
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
		}
		
		
	@BeforeMethod(alwaysRun = true)  //-->always execute this method
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		 landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun = true)  //-->always execute this method
	public void endApplication() {
		
		driver.quit();
	}
}