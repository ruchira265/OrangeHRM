package Common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner extends ReusableMethods implements ITestListener
{
	 String path = null;
	@Override  
	public void onTestStart(ITestResult result) {  
		
		test= extent.createTest(result.getMethod().getMethodName());
	
		System.out.println("The test is passed "+result.getTestName());
	}  
	
	@Override  
	public void onTestSuccess(ITestResult result) {  
		
		test.pass("Test completed");
		
		 try {
				//test.addScreenCaptureFromPath(capture());
				test.addScreenCaptureFromPath(screenshot(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) 
	{  
       test.fail("Failure!!");
       try {
    	//  test.addScreenCaptureFromPath(capture());
			test.addScreenCaptureFromPath(screenshot(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	try {
		path = screenshot("Failure");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     try {
		test.addScreenCaptureFromPath(path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
			System.out.println("Welcome to TC");
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		extent.flush();
	}  
}
