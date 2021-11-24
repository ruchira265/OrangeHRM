package pageObjectsRepository;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Common.ExcelLibrary;
import Common.ReusableMethods;

public class AddEmpObjects extends ReusableMethods
{


	   @FindBy(xpath ="//b[text()='PIM']")
	   WebElement my_pim_Link;
	   
	   @FindBy(id="menu_pim_addEmployee")
	   WebElement addEmpbtn;
	   
	   @FindBy(id="firstName")
	   WebElement firstName;
	   
	   @FindBy(id="middleName")
	   WebElement middleName;
	   
	   @FindBy(id="lastName")
	   WebElement lastname;
	


public void AddNewEmp() throws InterruptedException
{
	PageFactory.initElements(driver,this);
	
	
	eleCilck(my_pim_Link);
	
	Thread.sleep(6000);
	eleCilck(addEmpbtn);
	
	
	eleSendKeys(firstName,ExcelLibrary.readData("demo", 1, 0) );
	eleSendKeys(middleName, ExcelLibrary.readData("demo", 1, 1));
	eleSendKeys(lastname, ExcelLibrary.readData("demo", 1, 2));
	
}



}