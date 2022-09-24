package stepDefinitions;


import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utility.Hooks.getDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Login {

    LoginPage login = PageFactory.initElements(getDriver(), LoginPage.class);


    @Given("User has valid credentials")
    public void user_has_valid_credentials() {


        login.homepage();
        login.setValidUser();
        login.setValidPass();

    }

    @When("User logs in")
    public void user_logs_in() {
        login.clickLogin();

    }

    @Then("User logs in successfully")
    public void user_logs_in_successfully() {
        login.verifyLogin();
    }


    @Given("User has invalid credentials")
    public void user_has_invalid_credentials() {
        login.homepage();
        login.setInvalUser();
        login.setValidPass();

    }


    @Then("User fails to login")
    public void user_fails_to_login() {
        login.verifyInvalCred();

    }


}
