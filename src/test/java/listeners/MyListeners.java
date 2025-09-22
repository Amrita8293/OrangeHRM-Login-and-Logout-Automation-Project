package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{
	
	  public void onStart(ITestContext context) {
		    System.out.println("Test execution is starting......");
		  }
	
	  public void onTestStart(ITestResult result) {
		    System.out.println("Test execution is started...");
		  }
	  
	  public void onTestSuccess(ITestResult result) {
		    System.out.println("Test pass...");
		  }
	  public void onTestFailure(ITestResult result) {
		    System.out.println("Test fail...");
		  }
	  public void onTestSkipped(ITestResult result) {
		    System.out.println("Test skip...");
		  }

	  public void onFinish(ITestContext context) {
		    System.out.println("Test finished ...");
		  }
	

}
