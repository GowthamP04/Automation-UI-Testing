package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) throws InterruptedException {
		

		
		WebDriver driver =new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\GO20382992\\Downloads\\chromedriver.exe");

		driver.get("https://www.google.co.in/search?q=karur&source=hp&ei=GRaDZKq2KYDi2roP25KAoA0&iflsig=AOEireoAAAAAZIMkKbpp2EUDQ404NJ3GiqctsU1ByJMN&ved=0ahUKEwjqpuW_k7b_AhUAsVYBHVsJANQQ4dUDCAo&uact=5&oq=karur&gs_lcp=Cgdnd3Mtd2l6EAMyEQguEIAEELEDEIMBEMcBENEDMgsILhCABBCxAxDUAjILCAAQgAQQsQMQgwEyCAgAEIAEELEDMggIABCABBDJAzIICAAQigUQkgMyCAgAEIoFEJIDMgsIABCABBCxAxCDATIFCAAQgAQyBQgAEIAEOhAILhADEI8BEOoCEIwDEOUCOhAIABADEI8BEOoCEIwDEOUCOgsILhCKBRCxAxCDAToICC4QgAQQsQM6BQguEIAEOgsIABCKBRCxAxCDAToICC4QgAQQ1AI6CwguEIAEELEDEIMBOggILhCxAxCABDoLCC4QgwEQsQMQgARQ6wVYuhVgvRpoAXAAeACAAXOIAeYDkgEDNC4xmAEAoAEBsAEK&sclient=gws-wiz");
		//driver.findElement(By.xpath("//button[@class='M6CB1c rr4y5c']")).click();
		//driver.findElement(By.id("input")).sendKeys("karur"+ Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[1]/div/a/h3")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-gov']")).click();
		driver.findElement(By.className("sub-menu")).click();
		Thread.sleep(4000);
		driver.close();

			}
		

	}








//
//public class BrokenLinks {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","./src/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/broken");
//
//        //Storing the links in a list and traversing through the links
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//        // This line will print the number of links and the count of links.
//        System.out.println("No of links are "+ links.size());  
//      
//        //checking the links fetched.
//        for(int i=0;i<links.size();i++)
//        {
//            WebElement E1= links.get(i);
//            String url= E1.getAttribute("href");
//            verifyLinks(url);
//        }
//        
//        driver.quit();
//    }
//    
//    
//    public static void verifyLinks(String linkUrl)
//    {
//        try
//        {
//            URL url = new URL(linkUrl);
//
//            //Now we will be creating url connection and getting the response code
//            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
//            httpURLConnect.setConnectTimeout(5000);
//            httpURLConnect.connect();
//            if(httpURLConnect.getResponseCode()>=400)
//            {
//            	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
//            }    
//       
//            //Fetching and Printing the response code obtained
//            else{
//                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
//            }
//        }catch (Exception e) {
//      }
//   }
//}
