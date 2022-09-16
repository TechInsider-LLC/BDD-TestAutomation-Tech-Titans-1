package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Hooks;

public class CardFundingTransferPage {

    WebDriver getDriver = Hooks.getDriver();

    public String validUsername = "Demo-User";
    public String validPassword = "Demo-Access1";
    public String amount = "12";
    public String descriptionMessage = "Payment";

    public String URL = "https://demo.ebanq.com/log-in";
    public void load(){
        getDriver.get(URL);
    }

    @FindBy(xpath = "//input[@placeholder='Enter username or email address']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement passwordInput;

    @FindBy(css = "div[ng-reflect-router-link='/transfer']")
    public WebElement transfers;

    @FindBy(css = "div[ng-reflect-router-link='card-funding-transfer']")
    public WebElement cardFundingTransfer;

    @FindBy(css = ".select-container-large .ng-select-container")
    public WebElement selectAccount;

    @FindBy(css = ".ng-option-marked")
    public WebElement selectChecking;

    @FindBy(css = ".two-in-row :nth-child(2) .ng-value-container")
    public WebElement selectCard;

    @FindBy(css = ".ng-option-marked")
    public WebElement selectCreditAccount;

    @FindBy(css = "[ng-reflect-name='outgoingAmount']")
    public WebElement amountToTransfer;

    @FindBy(css = "#description")
    public WebElement description;

    @FindBy(css = "body")
    public WebElement body;

    @FindBy(css = ".bottom .def-btn-success")
    public WebElement continueButton;

    @FindBy(css = ".bottom .main_color")
    public WebElement confirmButton;

    @FindBy(css = ".success-popup .popup-message")
    public WebElement successPopupMessage;

    public String successMessage = "Your request has been sent for approval.";
}
