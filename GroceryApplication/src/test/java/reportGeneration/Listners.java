package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtendlReportUtility;

public class Listners implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtendlReportUtility.createExtentReports(); //ExtendReportUtility class configured in Listner class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {   //it execute before a testcase start, it fetch the method name of the testcase going to run using getMethod and getMethodName

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) { // it execute automatically when a testcase passes

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) { // it execute automatically when a testcase fails

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {

	e.printStackTrace();                 // to print the error in report
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace();
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (Exception e) {
	}
	}

	public void onTestSkipped(ITestResult result) { // it run when a testcase skipped

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {     //it run when the testcase failed before completing the success percentage

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {      // run when a testcase failed due to timeout

	ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) { // it run before a testcase starts

	ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) { // execute after completing all the above methods

	ITestListener.super.onFinish(context);
	extent.flush(); // used to log all the the details that fetched from the methods
	}

}
