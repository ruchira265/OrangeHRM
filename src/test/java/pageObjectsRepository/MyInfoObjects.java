package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Common.ExcelLibrary;
import Common.ReusableMethods;

public class MyInfoObjects extends ReusableMethods
{

	   @FindBy(xpath ="//b[text()='My Info']")
	   WebElement my_info_Link;
	   
	   @FindBy(id="btnSave")
	   WebElement editbtn;
	   
	   @FindBy(id="personal_txtEmpFirstName")
	   WebElement name;
	   
	   @FindBy(id="personal_txtEmpLastName")
	   WebElement lastname;
	   



public void EnterMyInfo(String fname,String lname) throws InterruptedException
{
	PageFactory.initElements(driver,this);
	eleCilck(my_info_Link);
	Thread.sleep(3000);
	eleCilck(editbtn);
	
	// to clear your text box
	name.clear();
	Thread.sleep(3000);
	
	eleSendKeys(name, fname);
	Thread.sleep(3000);
	
	lastname.clear();
	eleSendKeys(lastname, lname);
}

@DataProvider(name = "myInfoDB")
public Object[][] getData()
{
	Object [][] data = new Object[2][2];
	
	data[0][0] = "Rohan";
	data[0][1] = "DES";
	

	data[1][0] = "john";
	data[1][1] = "userJohn";
	
	return data;
	
}

public void excelData() throws Exception
{
	ExcelLibrary l = new ExcelLibrary();
	String data = l.readData("demo", 7, 0);
	System.out.println("Data comes from excel =="+data);
}
}