package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingCartPage extends BasePage {

    @FindBy(xpath = "//li[contains(@id,'gh-minicart-hover')]//i[contains(@id,'-n')]")
    private WebElement numberOfAddedItemsToCart;

    @FindBy(xpath = "//div[@id='mainContent']")
    private WebElement cartMainContent;

    @FindBy(xpath = "//div[contains(@id,'box2')]/input[@type='text']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,' details')]//span[@class='BOLD']")
    private List<WebElement> listOfProductsInCart;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeLink;

    @FindBy(xpath = "//div[@id='page-alerts']")
    private WebElement messageAfterDeletion;

    @FindBy(xpath = "//div[contains(@class,'actions')]/a[contains(@data-test-id,'shopping')]")
    private WebElement startShoppingButton;

    public ShippingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTheNumberOfAddedItemsToCart() {
        return numberOfAddedItemsToCart;
    }

    public WebElement getCartMainContent() {
        return cartMainContent;
    }

    public WebElement getSearchField() {
        return searchInputField;
    }

    public void enterKeywordIntoTheSearchField(final String keyWord) {
        searchInputField.sendKeys(keyWord);
    }

    public void clickOnTheSearchButton() {
        searchButton.click();
    }

    public List<WebElement> getListOfProductsInCart() {
        return listOfProductsInCart;
    }

    public List<String> getListOfProductsInCartString(List<WebElement> list) {
        return list.stream().map(i -> i.getText()).collect(Collectors.toList());
    }

    public WebElement getRemoveLink() {
        return removeLink;
    }

    public void clickOnRemoveLink() {
        removeLink.click();
    }

    public WebElement getMessageAfterDeletion() {
        return messageAfterDeletion;
    }

    public boolean checkVisibilityOfMessageAfterDeletion() {
        return messageAfterDeletion.isDisplayed();
    }

    public boolean checkVisibilityOfStartShoppingButton() {
        return startShoppingButton.isDisplayed();
    }

    public WebElement getStartShoppingButton() {
        return startShoppingButton;
    }
}
