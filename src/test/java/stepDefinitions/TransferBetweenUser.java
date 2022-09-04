package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class TransferBetweenUser {
    WebDriver driver;
    @Given("User successfully log in")
    public void user_successfully_log_in() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.ebanq.com/log-in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".fields-container [type=\"email\"]")).sendKeys("Demo-User");
        driver.findElement(By.cssSelector(".fields-container [type=\"password\"]")).sendKeys("Demo-Access1", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();

    }
    @When("User click on TransferBetweenUser")
    public void user_click_on_transfer_between_user() {
        driver.findElement(By.cssSelector("Transfers")).click();


    }
    @When("User fill out the form and confirm")
    public void user_fill_out_the_form_and_confirm() {

    }
    @Then("User get verify message")
    public void user_get_verify_message() {

    }
}
