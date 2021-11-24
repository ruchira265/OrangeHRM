package testCases;

import java.io.File;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import pageObjectsRepository.AddEmpObjects;
import pageObjectsRepository.LoginPageObjects;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AddEmpTest extends AddEmpObjects
{
	@Test
	public void testMyInfo() throws Exception
	{
		
		
		LaunchBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");	
		LoginPageObjects.perfom();
		AddNewEmp();
	}

	
	@Test
	public void test1() throws Exception
	{
		  
		LaunchBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");	
		  driver.manage().window().maximize();
		// create object of AShot and set image statergy and viewport method will to scroll down and takecreenshot to take screen shot
		Screenshot shtt = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver);
		//ImageIO.write(shtt.getImage(),"png" , "Ashot\\pic");
		ImageIO.write(shtt.getImage(), "png", new File("C:\\RENU\\Eclipse_Project\\com.OrangeHRM.Application\\target\\Ashot\\ct.png"));
	}

}
