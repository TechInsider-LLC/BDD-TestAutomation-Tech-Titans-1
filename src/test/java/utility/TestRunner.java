package utility;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@myTestTag",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "rerun:target/rerun/failedTests.txt",
                "json:target/cucumber/cucumber.json"}

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
