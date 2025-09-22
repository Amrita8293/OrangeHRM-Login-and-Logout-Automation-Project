package utilis;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;	//UI of the report
	public ExtentReports extent;	//populate common info on the report
	public ExtentTest test;		//creating test case entries in the report and update status of the test method
	
	public void onStart(ITestContext context) {
		sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/OrangeHRM.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report:OrangeHRM");	//Title of the report
		sparkReporter.config().setReportName("Functional Testing");		//Name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Amrita");
		extent.setSystemInfo("OS", "Window8");
		extent.setSystemInfo("Browser name", "Chrome");
	
	}
	
	public void onTestSuccess(ITestResult result) {
		   test = extent.createTest(result.getName());   //create new entry in report
		   test.log(Status.PASS, "Test case passed ...." +result.getName());	//update status
		  }
	
	public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.log(Status.FAIL, "Test case failed ..."+result.getName());
		 test.log(Status.FAIL, "Test case failed cause is :" +result.getThrowable());
		  }
	 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped...." +result.getName());
		  } 
	
	public void onFinish(ITestContext context) {
	extent.flush();
		  }
	
	

}
