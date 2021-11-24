package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectsRepository.CustomeFieldsObjects;
import pageObjectsRepository.LoginPageObjects;
import pageObjectsRepository.MyInfoObjects;

public class MyInfoTest extends MyInfoObjects
{

	@Test(dataProvider = "myInfoDB")
	public void testMyInfo(String fname,String lname) throws Exception
	{
		LaunchBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");	
		test.pass("MyInfoTest launched");
		LoginPageObjects.perfom();
		test.pass("Login successfully");
		EnterMyInfo(fname,lname);
		test.pass("Info Entered");
	}
	
	@Test(enabled = true)
	public void customFields() throws Exception
	{
		LaunchBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");	
		LoginPageObjects.perfom();
		CustomeFieldsObjects.enterBloodType();
		screenshot("CustomFiled");
		
	}
	
	

	@Test
	public void Attachments()
	{
		
	}
}
