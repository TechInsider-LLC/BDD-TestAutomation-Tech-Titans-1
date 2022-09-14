package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Hooks;


public class WireTransferPage {

    WebDriver getDriver = Hooks.getDriver();

    public String validUsername = "Demo-User";
    public String validPassword = "Demo-Access1";
    public String validAddress = "123 Bronx Ave";
    public String swiftCode = "SMCOGB2L";
    public String customerName = "Adam";
    public String customerCity = "Bronx";
    public String customerState ="New York";
    public String accountIban = "AL35202111090000000001234567";
    public String refMessage = "Test";
    public String amountToTransfer = "1000";

    public String URL = "https://demo.ebanq.com/log-in";
    public void load(){
        getDriver.get(URL);
    }
    @FindBy(xpath = "//input[@placeholder='Enter username or email address']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement passwordInput;

    @FindBy(css = ".header .aside-bar__menu-toggle")
    public WebElement headerMenu;

    @FindBy(css = "div[ng-reflect-router-link='/transfer']")
    public WebElement transfers;

    @FindBy(css = "div[ng-reflect-router-link='outgoing-wire-transfer']")
    public WebElement outgoingWireTransfer;

    @FindBy(css = ".select-container-large .ng-select-container")
    public WebElement selectAccount;

    @FindBy(css = ".ng-option-marked")
    public WebElement selectChecking;

    @FindBy(css = "#beneficiary-bankSwiftBic")
    public WebElement beneficiarySwiftBankCode;

    @FindBy(css = "#customer-name")
    public WebElement customerName1;

    @FindBy(css = "#customer-address")
    public WebElement customerAddress;

    @FindBy(css = "#customer-city")
    public WebElement customerCity1;

    @FindBy(css = "#customer-state-prov-region")
    public WebElement customerState1;

    @FindBy(css = "[ng-reflect-name='customerCountry']")
    public WebElement customerCountrySelect;

    @FindBy(css = ".ng-option:nth-child(235) .ng-option-label")
    public WebElement selectsUSA;

    @FindBy(css = "#acc-iban")
    public WebElement accountIban1;

    @FindBy(css = "#ref-message")
    public WebElement refMessage1;

    @FindBy(css = "#outgoingAmountOptionsPipe")
    public WebElement amountToTransfer1;

    @FindBy(css = "[ng-reflect-name='referenceCurrencyCode']")
    public WebElement selectCurrency;

    @FindBy(css = ".ng-option:nth-child(28) .ng-option-label")
    public WebElement selectUSA$;

    @FindBy(css = "body")
    public WebElement body;

    @FindBy(css = ".bottom .def-btn-success ")
    public WebElement continueButton;

    @FindBy(css = ".success-popup .popup-message")
    public WebElement successMessage1;

    @FindBy(css = ".error-word")
    public WebElement errorField;

    public String successMessage = "Your request has been sent for approval.";

    public String fieldsRequired = "Field is required.";



}
