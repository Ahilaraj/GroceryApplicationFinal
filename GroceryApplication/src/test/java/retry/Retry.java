package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class"); //logger and logmanager classes helps for retry mechanism
	private static final int maxTry = 2; // maxtry variable is the no:of time it should be retried. If it pass in first try then it will ignore in 2nd try. If it fails in normal run and first try and then 2nd try then it will failed, so here total no:of excecution in this case is 3
	private int count = 0; // count variable  is used to track how many retry is done here.In this case total count will be 3(normal + 2 retry) , if we have network connection and any testcase skipped then it will run automatically then total count will be 4

	@Override  //overridden from IRetryAnalyser interface
	public boolean retry(final ITestResult iTestResult) {
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}

}
