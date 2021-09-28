package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'box-marpad ')]")
    private WebElement productPanelWithActionButtons;

    @FindBy(xpath = "//a[contains(@id,'tBtn_btn')][contains(@class,'btnWdth-XL')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class,'im  vi-VR-btnWdth-XL')]")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//div[@class='oly_container']")
    private WebElement signInToCheckOutPopup;

    @FindBy(xpath = "//div[@class='oly_container']//button[@id='sbin-gxo-btn']")
    private WebElement checkOutAsGuestButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkVisibilityOfAddToCartButton() {
        return addToCartButton.isDisplayed();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public boolean checkVisibilityOfBuyItNowButton() {
        return buyItNowButton.isDisplayed();
    }

    public void clickOnBuyItNowButton() {
        buyItNowButton.click();
    }

    public boolean checkVisibilityOfSignInToCheckoutPopup() {
        return signInToCheckOutPopup.isDisplayed();
    }

    public WebElement getSignInToCheckOutPopup() {
        return signInToCheckOutPopup;
    }

    public void clickOnCheckOutAsGuestButton() {
        checkOutAsGuestButton.click();
    }

    public WebElement getCheckOutAsGuestButton() {
        return checkOutAsGuestButton;
    }

    public WebElement getProductPanelWithActionButtons() {
        return productPanelWithActionButtons;
    }
}
