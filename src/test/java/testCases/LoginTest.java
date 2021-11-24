package testCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Common.ReusableMethods;
import pageObjectsRepository.LoginPageObjects;

public class LoginTest extends ReusableMethods
{
	
	

	@Test
	public static void login() throws Exception
	{
		LaunchBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");	
		
		test.pass("URL is launched ");
		
		LoginPageObjects.perfom();
		Assert.assertTrue(false);
		screenshot("LoginPage");
		
		
		
	/*	test.fail("Window is not close ");
		test.fatal("Webapge is Open");
		test.info("This is a login Test ");
		test.error("There is coding error ");*/
	}
}
