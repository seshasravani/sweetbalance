package testRunner;



import io.cucumber.junit.CucumberOptions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Feature/PremiumUser_Homepage.feature"},

    glue = {"stepDefinitions", "hooks"},
    dryRun = false,
    monochrome = true,
    plugin = {
    		"pretty","html:target/SweetBalanceApplication.html",
			  "html:target/cucumber-reports/reports.html",
			  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
	          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-report.html",// Generates readable and HTML reports
	          "rerun:target/failedrerun.txt",
	          "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"})
	        
    

public class TestRunner {
    // No need to extend anything or add @DataProvider
}



//@CucumberOptions(//Cucumber Test Runner using TestNG
//
//		plugin = {"pretty","html:target/SweetBalanceApplication.html",
//				  "html:target/cucumber-reports/reports.html",
//				  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//		          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-report.html",// Generates readable and HTML reports
//		          "rerun:target/failedrerun.txt",
//		          "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
//		         monochrome=false, // If true, enables colored console output (more readable)
//		features = {"/src/test/resources/features/PremiumUser_Homepage.feature"}, // Path to the feature files
// 		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks
//
//  public class TestRunner {
////  extends AbstractTestNGCucumberTests{	
////	String browser;
////	@Override
////	@DataProvider(parallel = false) // Set to true for parallel scenario execution and set false for crossbrowser
////	public Object[][] scenarios(){
////		return super.scenarios();
////	}	
////	
////	@BeforeClass    //Enable during cross browser testing
////	@Parameters("browser")	//Inject browser value from testng-parallel.xml into this method for cross browser execution
////	public void defineBrowser(@Optional String browser) throws Throwable {
////		this.browser = browser;
////		if(browser != null && !browser.equals("param-val-not-found")) {
////			ConfigReader.setBrowserType(browser);
////		}
////	}
//}
