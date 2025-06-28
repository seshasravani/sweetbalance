package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = {"stepdefinition", "hooks"},
		features= {"@target/failedrerun.txt"},
		plugin= {"pretty",
		"html:target/failed-cucumber-reports.html"},
		monochrome = true
	)	

 public class ReRunner extends AbstractTestNGCucumberTests {

 }
