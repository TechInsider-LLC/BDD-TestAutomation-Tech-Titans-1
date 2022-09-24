package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OutgoingWireTransferPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utility.Hooks.getDriver;

public class OutgoingWireTransfer {

    String username;
    String password;
    String address;
    String swiftCode;
    String customerName;
    String customerCity;
    String customerState;
    String accountIban;
    String refMessage;
    String amountToTransfer;


    OutgoingWireTransferPage transferPage = PageFactory.initElements(getDriver(), OutgoingWireTransferPage.class);

    @Given("User on the Ebanq page")
    public void user_on_the_ebanq_page() {
        username = transferPage.validUsername;
        password = transferPage.validPassword;
        address = transferPage.validAddress;
        swiftCode = transferPage.swiftCode;
        customerName = transferPage.customerName;
        customerCity = transferPage.customerCity;
        customerState = transferPage.customerState;
        accountIban = transferPage.accountIban;
        refMessage = transferPage.refMessage;
        amountToTransfer = transferPage.amountToTransfer;
        transferPage.load();
    }
    @When("User Logs in and click on transfers then click on Outgoing wire Transfer")
    public void user_logs_in_and_click_on_transfers_then_click_on_outgoing_wire_transfer() throws InterruptedException {
//        Thread.sleep(3000);
        transferPage.usernameInput.sendKeys(transferPage.validUsername);
        transferPage.passwordInput.sendKeys(transferPage.validPassword,Keys.ENTER);
       Thread.sleep(4000);
//        transferPage.headerMenu.click();
//        Thread.sleep(2000);
        transferPage.transfers.click();
//        Thread.sleep(3000);
        transferPage.outgoingWireTransfer.click();


    }
    @When("Select account and fills the form then click on continue")
    public void select_account_and_fills_the_form_then_click_on_continue() throws InterruptedException {
        Thread.sleep(2000);
        transferPage.selectAccount.click();
//        Thread.sleep(1000);
        transferPage.selectChecking.click();
        transferPage.beneficiarySwiftBankCode.sendKeys(swiftCode);
        transferPage.customerName1.sendKeys(customerName);
        transferPage.customerAddress.sendKeys(address);
        transferPage.customerCity1.sendKeys(customerCity);
        transferPage.customerState1.sendKeys(customerState);
        transferPage.customerCountrySelect.click();
        transferPage.selectsUSA.click();
        transferPage.accountIban1.sendKeys(accountIban);
        transferPage.refMessage1.sendKeys(refMessage);
        transferPage.amountToTransfer1.sendKeys(amountToTransfer);
        transferPage.selectCurrency.click();
        transferPage.selectUSA$.click();
        Thread.sleep(3000);
        transferPage.body.sendKeys(Keys.CONTROL,Keys.END);
        transferPage.continueButton.click();
    }

    @When("User on Transfer details page Scrolls down end click on continue")
    public void user_on_transfer_details_page_scrolls_down_end_click_on_continue() throws InterruptedException {
        transferPage.body.sendKeys(Keys.CONTROL,Keys.END);
        Thread.sleep(3000);
        transferPage.continueButton.click();
    }
    @Then("Users Transaction success")
    public void users_transaction_success() throws InterruptedException {
//        Thread.sleep(2000);
        String expected = transferPage.successMessage.trim();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(transferPage.successMessage1,expected));
        String actual = transferPage.successMessage1.getText().trim();
        assertTrue(actual.contains(expected));
    }




    @When("User Scroll down click on continue button")
    public void user_scroll_down_click_on_continue_button() throws InterruptedException {
        transferPage.body.sendKeys(Keys.CONTROL,Keys.END);
        Thread.sleep(3000);
        transferPage.continueButton.click();
    }
    @Then("User Should get error message")
    public void user_should_get_error_message() throws InterruptedException {
        Thread.sleep(2000);
        String expected = transferPage.fieldsRequired;
        String actual = transferPage.errorField.getText().trim();
        assertEquals(expected,actual);
    }
}


