package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingUp {

    WebDriver driver = new ChromeDriver();
    String username;
    String password;
    String gmail;

    @Given("Customer go to EBANQ homepage")
    public void customer_go_to_ebanq_homepage() {
        username= "demo";
        password= "Demoebanq1$";
        gmail= "Demo@gmail.com";
        driver.get("https://demo.ebanq.com/log-in");

    }
    @When("Customer enter all the requirements")
    public void customer_enter_all_the_requirements() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("[href=\"/sign-up\"]")).click();
        driver.findElement(By.cssSelector("#first-n-input")).sendKeys(username);
        driver.findElement(By.cssSelector("#last-name-input")).sendKeys(username);
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#em")).sendKeys(gmail);
        driver.findElement(By.cssSelector("#confirm-em")).sendKeys(gmail);
        driver.findElement(By.cssSelector("#no-autocomplete")).sendKeys(password);
        driver.findElement(By.cssSelector("#confirm-ps")).sendKeys(password);
        driver.findElement(By.cssSelector("#securityQuestionId")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#a1a880648b57"),"Name"));
        driver.findElement(By.cssSelector(".ng-dropdown-panel-items .ng-option")).click();




        

        driver.findElement(By.cssSelector("#sequrityQuestionAnswer")).sendKeys("demo");
        driver.findElement(By.cssSelector(".checkbox-checkmark")).click();
        driver.findElement(By.cssSelector(".checkbox-checkmark")).submit();
    }
    @Then("Customer see success message")
    public void customer_see_success_message() {

    }


}
