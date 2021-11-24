package Common;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReusableMethods 
{

	public static WebDriver driver= null; // gobal
	String URL = "https://opensource-demo.orangehrmlive.com/"; // saved in variable 

	static ExtentHtmlReporter htmlreport;
	protected static ExtentTest test ;
	static ExtentReports extent;
	
	@BeforeTest
	public void ReportConfig()
	{
		// path of your report to get store 
				htmlreport  = new ExtentHtmlReporter("C:\\RENU\\Eclipse_Project\\com.OrangeHRM.Application\\target\\Reports\\re.html");
			      
				
				// set configuration
				htmlreport.config().setReportName("Testing Report");
				htmlreport.config().setDocumentTitle("OrangeHRM Demo");
				htmlreport.config().setTheme(Theme.DARK);
				
			  extent = new ExtentReports();
			  extent.attachReporter(htmlreport);
			 // test = extent.createTest("TestInfo");
	}
	
	
	
	
	
	
		// Launching the Code in different browser
		
		public static void LaunchBrowser(String browsername , String URL) throws Exception
		{
			switch(browsername)
			{
			case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\RENU\\JARS\\chromedriver_win\\chromedriver.exe");
			// Create an object of Driver with sp browser 
			 driver = new ChromeDriver();
			// open the URL 
			driver.get(URL);
			ExcelLibrary e = new ExcelLibrary();
			break;
			
			case "IE":
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Ruchira\\Documents\\Set_Up\\JARS\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
				// Create an object of Driver with sp browser 
				 driver = new InternetExplorerDriver();
				
				// open the URL 
				driver.get(URL);
			break;
			}
		}
		
		
		
		public static WebElement findElement(String type,String value)
		{
			WebElement ele=null;
			switch(type)
			{
			case "Id":
				ele = driver.findElement(By.id(value));
				System.out.println("element is display =="+ele.isDisplayed() + " " + ele.isEnabled());
				break;
			case "Class":
				ele = driver.findElement(By.className(value));
				break;
			case "Name":
			ele =	driver.findElement(By.name(value));
				break;
			case "Css":
				ele=driver.findElement(By.cssSelector(value));
				break;
			case "Xpath":
			ele = 	driver.findElement(By.xpath(value));
				break;
			}

			return ele;
		}
		
		// Clcking on the element
		public static void eleCilck(WebElement ele)
		{
			ele.click();
		}
		
		// sending values to the Text boxes 
		public static void eleSendKeys(WebElement ele,String text)
		{
			ele.sendKeys(text);
		}
		
		
		//customized your dropdown 
		public void select_Dropdown(WebElement ele,String type,int index,String val)
		{
		  Select s = new Select(ele);	
		  
		  switch(type)
		  {
		  case "Index":
			  s.selectByIndex(0);
			   break;
		  case "Value":
			  s.selectByValue(val);
			  break;
		  case "Text":
			  s.selectByVisibleText(val);
			  break;
		  }
		}
		
		// handling dynamic way
		public static void dynamic_Dropdown(WebElement ele,String txt)
		{
			 Select s = new Select(ele);	
			 
			List<WebElement> data =  s.getOptions();
			
			for(WebElement name : data)
			{
				  if(name.getText().equalsIgnoreCase(txt))
				  {
					  name.click();
				  }
			}
			
		}
		
		
		// Findelements - returns multiple elements
		public void findelemnts(List<WebElement>ele,String value)
		{
			
			for(WebElement i : ele)
			{
				if(i.getAttribute("value").contains(value))
				{
					i.click();
				}
			}
			
		}
		
		
		// Window Handle 
		public void windows(String parentWindow)
		{
			Set<String> handle = driver.getWindowHandles();
			
			for(String e : handle)
			{
				if(!e.equals(parentWindow))
				{
					driver.switchTo().window(e);
				}
			}
		}
		
		
		// frame Handling 
		public void frames(WebElement frameName)
		{
			driver.switchTo().frame(frameName);
		}
		
		
		// Taking Screenshot 
		public static String screenshot(String FileName) throws IOException
		{
			String path =  "C:\\RENU\\Eclipse_Project\\com.OrangeHRM.Application\\target\\ScreeshShot\\"+FileName
					+".png";
			TakesScreenshot tk = (TakesScreenshot) driver;
			File source = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,  new File(path));
			return path;
		}
		
		public String capture() throws IOException
		{
			String path = "C:\\RENU\\Eclipse_Project\\com.OrangeHRM.Application\\target\\ScreeshShot\\pic.png";
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srccpic = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srccpic, new File(path));
		
			return path;
			

		}
}
