package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.getDriver;

public class LoginPage {

    // EBANQ CREDENTIALS
    //User Credentials: Demo-User
    //Password: Demo-Access1

    public String username = "Demo-User";
    public String password = "Demo-Access1";
    public String invalUser = "";
    public String invalPass = "";
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public void homepage() {
        getDriver().get("https://demo.ebanq.com/log-in");
    }

    public void setValidUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(1) > input"))).sendKeys(username);
    }

    public void setValidPass() {
        getDriver().findElement(By.cssSelector(":nth-child(2) > input")).sendKeys(password);
    }

    public void setInvalUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(1) > input"))).sendKeys(invalUser);
    }

    public void setInvalPass() {
        getDriver().findElement(By.cssSelector(":nth-child(2) > input")).sendKeys(invalPass);

    }

    public void clickLogin() {
        getDriver().findElement(By.cssSelector("div.controls > button")).click();
    }

    public void verifyLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.controls > div > span")));
    }

    public void verifyInvalCred(){
        getDriver().findElement(By.cssSelector("div.fields-container label"));
    }


}


//        String username = "Demo-User";
//        String password = "Demo-Access1";
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//
//        getDriver().get("https://demo.ebanq.com/log-in");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(":nth-child(1) > input"))).sendKeys(username);
//        getDriver().findElement(By.cssSelector(":nth-child(2) > input")).sendKeys(password);
//        getDriver().findElement(By.cssSelector("div.controls > button")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.controls > div > span")));


//        getDriver().findElement(By.cssSelector("div.fields-container label"));   // check for invalid username/password being entered