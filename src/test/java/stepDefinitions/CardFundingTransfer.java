package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CardFundingTransferPage;


import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static utility.Hooks.getDriver;

public class CardFundingTransfer {


    CardFundingTransferPage fundingTransfer = PageFactory.initElements(getDriver(), CardFundingTransferPage.class);


    String username;
    String password;
    String amount;
    String descriptionMessage;

    @Given("User is on Ebanq page")
    public void user_is_on_ebanq_page() {
        username = fundingTransfer.validUsername;
        password = fundingTransfer.validPassword;
        amount = fundingTransfer.amount;
        descriptionMessage = fundingTransfer.descriptionMessage;
        fundingTransfer.load();
    }
    @When("User Logs in and click on transfers then click on Card Funding Transfer")
    public void user_logs_in_and_click_on_transfers_then_click_on_card_funding_transfer() throws InterruptedException {

        fundingTransfer.usernameInput.sendKeys(fundingTransfer.validUsername);
        fundingTransfer.passwordInput.sendKeys(fundingTransfer.validPassword,Keys.ENTER);
        Thread.sleep(3000);
        fundingTransfer.transfers.click();
        fundingTransfer.cardFundingTransfer.click();
    }
    @When("User Select account click Continue and clicks confirm")
    public void user_select_account_click_continue_and_clicks_confirm() throws InterruptedException {
        fundingTransfer.selectAccount.click();
        fundingTransfer.selectChecking.click();
        fundingTransfer.selectCard.click();
        fundingTransfer.selectCreditAccount.click();
        fundingTransfer.amountToTransfer.sendKeys(amount);
        fundingTransfer.description.sendKeys(descriptionMessage);
        fundingTransfer.body.sendKeys(Keys.CONTROL,Keys.END);
        WebDriverWait driverWait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bottom .def-btn-success"))).click();
        fundingTransfer.continueButton.click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bottom .main_color"))).click();
        fundingTransfer.confirmButton.click();


    }
    @Then("User sees success message")
    public void user_sees_success_message(){
        String expected = fundingTransfer.successMessage;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(fundingTransfer.successPopupMessage,expected));
        String actual = fundingTransfer.successPopupMessage.getText().trim();
        assertTrue(actual.contains(expected));
    }
}
