package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SignUpPage;
import utility.RandomText;

import java.time.Duration;

import static utility.Hooks.getDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUp {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    SignUpPage signup= PageFactory.initElements(getDriver(),SignUpPage.class);
    RandomText random = new RandomText();
    String email = random.getRandomGmail(8);
    StringBuilder name= random.getRandomText(8);
    String password;

    // SUCCESSFUL SIGN UP

    @Given("Customer go to EBANQ homepage")
    public void customer_go_to_ebanq_homepage() {
        password= "Demoebanq1$";
        getDriver().get(signup.homeURL);
    }
    @When("Customer enter all the requirements")
    public void customer_enter_all_the_requirements() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/sign-up\"]"))).click();
        signup.firstNameInput.sendKeys(name);
        signup.lastNameInput.sendKeys(name);
        signup.usernameInput.sendKeys(name);
        signup.emailInput.sendKeys(email);
        signup.confirmEmailInput.sendKeys(email);
        signup.passwordInput.sendKeys(password);
        signup.confirmPasswordInput.sendKeys(password);
        signup.securityQuestion.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-option:nth-child(3)"))).click();
        signup.securityQuestionAnswerInput.sendKeys(name);
        signup.checkbox.click();
        signup.submitSignUpButton.click();


    }
    @Then("Customer see success message")
    public void customer_see_success_message() throws InterruptedException {
        String expected = signup.successMessage.trim();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-popup .popup-message"))).getText().trim();
        assertTrue(actual.contains(expected));

    }


    // SIGN UP AS CORPORATE

    @Given("User go to EBANQ page")
    public void user_go_to_ebanq_page() {
        password= "Demoebanq1$";
        getDriver().get(signup.homeURL);
    }
    @When("User enter all requirements")
    public void user_enter_all_requirements() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/sign-up\"]"))).click();
        signup.profileType.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-option:nth-child(2)"))).click();
        signup.companyName.sendKeys(name);
        signup.firstNameInput.sendKeys(name);
        signup.lastNameInput.sendKeys(name);
        signup.usernameInput.sendKeys(name);
        signup.emailInput.sendKeys(email);
        signup.confirmEmailInput.sendKeys(email);
        signup.passwordInput.sendKeys(password);
        signup.confirmPasswordInput.sendKeys(password);
        signup.securityQuestion.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-option:nth-child(3)"))).click();
        signup.securityQuestionAnswerInput.sendKeys(name);
        signup.checkbox.click();
        signup.submitSignUpButton.click();
    }
    @Then("User see success message")
    public void user_see_success_message() throws InterruptedException {
       String expected = signup.successMessage.trim();
       String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-popup .popup-message"))).getText().trim();
        assertTrue(actual.contains(expected));
    }

    // SIGN UP FAILED

    @Given("User at EBANQ page")
    public void user_at_ebanq_page() {
        getDriver().get(signup.homeURL);
    }
    @When("User signup without info")
    public void user_signup_without_info() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/sign-up\"]"))).click();
        Actions hover = new Actions(getDriver());
        hover.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".controls__submit:last-child")))).perform();
        signup.submitSignUpButton.click();

    }

    @Then("User see message")
    public void user_see_message() throws InterruptedException {
        String expected = signup.errorMessage;
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fields-container__row:nth-child(3) .input-field .error-word"))).getText().trim();
        assertEquals(expected,actual);
    }




}
