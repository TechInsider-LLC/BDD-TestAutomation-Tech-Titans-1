package stepDefinitions;


import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@regression",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber/cucumber-reports.html",
                    "json:target/cucumber/cucumber.json"
    }
)
public class TestRunner {
}
