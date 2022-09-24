package stepDefinitions;

<<<<<<< HEAD

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
=======
>>>>>>> origin/main

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@myTestTag",
        dryRun = false,
<<<<<<< HEAD
        plugin = {"pretty", "html:target/cucumber/cucumber-reports.html",
                    "json:target/cucumber/cucumber.json"
    }
=======
        plugin = {"pretty", "html:target/cucumber-reports.html"}

>>>>>>> origin/main
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
