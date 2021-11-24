package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest 
{
	
	ExtentHtmlReporter htmlreport;
	ExtentTest test ;
	ExtentReports extent;
	
	@BeforeTest
	public void basicConfig()
	{
		// path of your report to get store 
		htmlreport  = new ExtentHtmlReporter("C:\\RENU\\Eclipse_Project\\com.OrangeHRM.Application\\target\\Reports\\re.html");
	      
		
		// set configuration
		htmlreport.config().setReportName("Testing Report");
		htmlreport.config().setDocumentTitle("OrangeHRM Demo");
		htmlreport.config().setTheme(Theme.DARK);
		
	  extent = new ExtentReports();
	  extent.attachReporter(htmlreport);
	  
	 
		
		
	
	}
	

	@Test
	public void tc1()
	{
	   test = extent.createTest("TC01");
	   
	   
	   extent.flush();
		
	}

	@Test
	public void tc2()
	{
		
	}
}
