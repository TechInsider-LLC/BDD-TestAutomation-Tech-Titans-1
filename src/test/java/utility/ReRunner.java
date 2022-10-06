package utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/rerun/failedTests.txt"},
        glue = {"stepDefinitions","utility"},
        plugin = {"rerun:target/rerun/failedTests2.txt",
                  "pretty", "html:target/rerun-cucumber-reports.html",
                "json:target/cucumber/rerun-cucumber.json"}
        )

public class ReRunner extends AbstractTestNGCucumberTests {
}
