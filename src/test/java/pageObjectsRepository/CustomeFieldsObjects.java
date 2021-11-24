package pageObjectsRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.ReusableMethods;

public class CustomeFieldsObjects extends ReusableMethods
{
	static WebElement bloodType;
	static WebElement my_info_link;
	static WebElement editbtn;
	
	
	public static void enterBloodType()
	{
		
		my_info_link = findElement("Xpath","//b[text()='My Info']");
		// To hanlde dropdown with select type 
		eleCilck(my_info_link);
		
		editbtn = findElement("Id", "btnEditCustom");
		eleCilck(editbtn);
		
		bloodType = findElement("Name","custom1");
		dynamic_Dropdown(bloodType,"B-");
		
		//Select s = new Select(bloodType);
		//s.selectByIndex(4);
	}

}
