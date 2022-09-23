package stepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@myTestTag",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
