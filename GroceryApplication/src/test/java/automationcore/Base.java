package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	
	public WebDriver driver; // webdriver is an interface in selenium.
	
	Properties pro;
	FileInputStream file;



@BeforeMethod (alwaysRun =true) //alwaysrun=true used to run initiazlie browser and close browser to run in grouping
@Parameters("browsers")
public void initializeBrowser(String browsers) throws IOException
{
	pro= new Properties();
	file = new FileInputStream(Constant.CONFIGFILE);
	pro.load(file);
	if(browsers.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver(); // chromedriver is a class to open chrome
	}
	
	else if(browsers.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	
	else if(browsers.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver();
		driver=new EdgeDriver();
		
	}

driver.get(pro.getProperty("url")); //method to launch url
driver.manage().window().maximize(); //methods to maximise window

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

@AfterMethod (alwaysRun = true)
public void driverQuit(ITestResult iTestResult) throws IOException {

if (iTestResult.getStatus() == ITestResult.FAILURE) {

ScreenshotUtility screenShot = new ScreenshotUtility();
screenShot.getScreenshot(driver, iTestResult.getName()); // to store the method name of failed test case
}
//driver.quit();

}

}