package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@myTestTag",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}

        features = "src/test/java/features",
        glue = "stepDefinitions"

)
public class TestRunner {
}
