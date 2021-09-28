package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@id,'box2')]/input[@type='text']")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfSearchFieldIsVisible() {
        return searchInputField.isDisplayed();
    }

    public void enterKeywordIntoTheSearchField(final String searchText) {
        searchInputField.clear();
        searchInputField.sendKeys(searchText);
    }

    public void clickOnTheSearchButton() {
        searchButton.click();
    }
}
