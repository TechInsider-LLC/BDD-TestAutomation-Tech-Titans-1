package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utility.Hooks.getDriver;

public class TransferBetweenUser {

    String id;
    @Given("User successfully log in")
    public void user_successfully_log_in() throws InterruptedException {
        getDriver().get("https://demo.ebanq.com/log-in");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector(".fields-container [type=\"email\"]")).sendKeys("Demo-User");
        getDriver().findElement(By.cssSelector(".fields-container [type=\"password\"]")).sendKeys("Demo-Access1", Keys.ENTER);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);







    }
    @When("User click on TransferBetweenUser")
    public void user_click_on_transfer_between_user() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector("div[ng-reflect-router-link=\"transfer-between-users\"]")).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector("div[class=\"ng-value-container\"]")).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector("DIV[class=\"ng-option ng-option-marked\"]")).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }
    @When("User fill out the form and confirm")
    public void user_fill_out_the_form_and_confirm() throws InterruptedException {
        getDriver().findElement(By.cssSelector("#username")).sendKeys("jsmith");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector("#account")).sendKeys("EBQ22123487654");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).sendKeys("1");
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        Thread.sleep(2000);



    }
    @Then("User get verify message")
    public void user_get_verify_message() {
       //actual=  driver.findElement(By.cssSelector(".popup-message [href=\"/transfer\"]")).getText().trim();
        String expected = " Your request has been sent for approval. ".trim();
        String actual = getDriver().findElement(By.cssSelector(".success-popup .popup-message")).getText();
        System.out.println(actual);
        assertTrue(actual.contains(expected));

       id= actual.split("ID #")[1].split("Back")[0].trim();
    }
    @When("Admin executed transaction")
    @Test
    public void admin_executed_transaction() {
        //admin login
        Response response =
                given().contentType("application/json")
                        .body("{\"data\":{\"email\":\"Bank-Admin\",\"password\":\"Demo-Access1\"}}")
                        .when().post("https://api-demo.ebanq.com/users/public/v1/auth/signin")
                        .then().log().all().statusCode(200).extract().response();

        String token = response.path("data.accessToken");
        Cookies cookies = response.getDetailedCookies();

        //executed
        String actual =
                given().log().all()
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + token)
                        .cookies(cookies)
                        .when().post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/{id}", id)
                        .then().log().all().statusCode(200).extract().path("data.status");

        String expected = "executed";
        assertEquals(expected, actual);
    }



}

