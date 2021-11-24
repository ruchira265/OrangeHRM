package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import Common.ReusableMethods;

public class LoginPageObjects extends ReusableMethods
{
	
	 // Webelenment Declartations
	static WebElement username;
	static WebElement password;
	static WebElement loginbtn;
	
	
	public static void findelement()
	{
		username = findElement("Id", "txtUsername");
		password = findElement("Id", "txtPassword");
		loginbtn = findElement("Id", "btnLogin");
	}

	
	public static void perfom()
	{
		findelement();
		eleSendKeys(username, "Admin");
		test.pass("UserName Entered");
		
		eleSendKeys(password, "admin123");
		test.pass("Password Enter");
		
		Assert.assertEquals("Admin", "Admin","uname and pwd are not same ");
		test.fail("Uname and pwd is not matched");
		
		eleCilck(loginbtn);
	}
}
