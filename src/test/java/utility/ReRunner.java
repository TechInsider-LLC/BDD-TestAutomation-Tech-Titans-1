package utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/rerun.txt"},
        glue = {"stepDefinitions","utility"},
        plugin = {"rerun:target/rerun/rerun.txt",
                  "pretty", "html:target/rerun/rerun-cucumber-reports.html"}
        )

public class ReRunner extends AbstractTestNGCucumberTests {
}
