package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='bodyContent']")
    private WebElement checkoutPanel;

    @FindBy(xpath = "//div[@class='quantity-update']")
    private WebElement productQuantityFieldWrapper;

    @FindBy(xpath = "//span[@class='select ']")
    private WebElement productQuantityField;

    @FindBy(xpath = "//span[@class='select ']/select[contains(@id,'qty-BId')]")
    private WebElement updatedAmountOfItems;

    @FindBy(xpath = "//span[@class='select ']//option[@value='2']")
    private WebElement selectOptionValue;

    @FindBy(xpath = "//tr[@data-test-id='SUB_TOTAL']//span[contains(@aria-hidden,'false')]")
    private WebElement amountOfItemsInCart;

    @FindBy(xpath = "//select[contains(@id,'qty-BId')]")
    private WebElement selectDropDown;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInputField;

    @FindBy(xpath = "//input[@id='addressLine1']")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='emailConfirm']")
    private WebElement confirmEmailInputField;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement phoneNumberInputField;

    @FindBy(xpath = "//button[contains(@data-test-id,'SUBMIT')]")
    private WebElement submitButton;

    @FindBy(xpath = "//section[@data-test-id='SHIPPING']")
    private WebElement shipToAddressPanel;

    @FindBy(xpath = "//div[@id='email-error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'-mask')]")
    private WebElement enabledPaymentPanel;

    @FindBy(xpath = "//tr[@data-test-id='TOTAL']//span[@class='text-display']/span")
    private WebElement orderTotalAmount;

    @FindBy(xpath = "//span[@class='select ']//option[@value='10+']")
    private WebElement selectOptionValue2;

    @FindBy(xpath = "//form[@name='quantity-update']/a[@class='ml-3']")
    private WebElement updateButton;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    private WebElement setNumberOfItemsField;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAmountOfItemsInCart() {
        return amountOfItemsInCart;
    }

    public WebElement getCheckoutPanel() {
        return checkoutPanel;
    }

    public boolean checkIfCheckoutPanelIsDisplayed() {
        return checkoutPanel.isDisplayed();
    }

    public WebElement getProductQuantityFieldWrapper() {
        return productQuantityFieldWrapper;
    }

    public void clickOnProductQuantityField() {
        productQuantityField.click();
    }

    public void clickOnSelectOptionValue() {
        selectOptionValue.click();
    }

    public void fillInTheFirstNameInputField(final String keyword) {
        firstNameInputField.sendKeys(keyword);
    }

    public void fillInTheLastNameInputField(final String keyword) {
        lastNameInputField.sendKeys(keyword);
    }

    public void fillInCityInputField(final String keyword) {
        cityInputField.sendKeys(keyword);
    }

    public void fillInStreetAddressInputField(final String keyword) {
        streetAddressInput.sendKeys(keyword);
    }

    public void fillInEmailInputField(final String keyword) {
        emailInputField.sendKeys(keyword);
    }

    public void fillInConfirmEmailInputField(final String keyword) {
        confirmEmailInputField.sendKeys(keyword);
    }

    public void fillInPhoneNumberInputField(final String keyword){
        phoneNumberInputField.sendKeys(keyword);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public WebElement getShipToAddressPanel() {
        return shipToAddressPanel;
    }

    public boolean isShipToAddressPanelIsDisplayed() {
        return shipToAddressPanel.isDisplayed();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public boolean checkIfPaymentPanelIsInactive() {
        return enabledPaymentPanel.isEnabled();
    }

    public WebElement getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void clickOnSelectOptionValue2() {
        selectOptionValue2.click();
    }

    public WebElement getSelectOptionValue2() {
        return selectOptionValue2;
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public void clickOnUpdateButton() {
        updateButton.click();
    }

    public void enterZeroNumberOfItems(final String number) {
        setNumberOfItemsField.clear();
        setNumberOfItemsField.sendKeys(number);
    }
}
