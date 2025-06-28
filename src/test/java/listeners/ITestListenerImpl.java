package listeners;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl implements ITestListener {//This tells TestNG to attach a custom listener to your test suite execution. Let me break it down:

	private static final Logger logger = LogManager.getLogger(ITestListenerImpl.class);
	
	  	@Override
	    public void onTestStart(ITestResult result) {//this all methods tell us the functionality of each testcase
	        //System.out.println("Test Started: " + result.getName());
	  		logger.info("Test Started: " + result.getName());
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {//when perticular test case is excute successfully this system out line is print
	        //System.out.println("Test Passed");
	    	logger.info("Test Passed: " + result.getName());
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	        //System.out.println("Test Failed");
	    	logger.error("Test Failed: " + result.getName(), result.getThrowable());
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        //System.out.println("Test Skipped: " + result.getName());
	    	logger.warn("Test Skipped: " + result.getName());
	    }
}
