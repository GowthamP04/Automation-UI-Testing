package properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eng {

	public static void main(String[] args) throws FileNotFoundException, IOException {// throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
Properties properties = new Properties();
properties.load(new FileInputStream(".\\src\\test\\java\\properties\\Eng.properties"));
String a=properties.getProperty("Welcome");
System.out.println(a);
	}
	
}
