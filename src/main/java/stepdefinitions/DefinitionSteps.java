package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    ProductPage productPage;
    SearchResultPage searchResultPage;
    ShippingCartPage shippingCartPage;
    CheckoutPage checkoutPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(30);
        homePage.checkIfSearchFieldIsVisible();
    }

    @When("User enters the keyword {string} into the search field")
    public void enterTheKeywordIntoTheSearchField(final String keyword) {
        homePage.enterKeywordIntoTheSearchField(keyword);
    }

    @And("User clicks on search button")
    public void clickOnSearchButton() {
        homePage.clickOnTheSearchButton();
    }

    @Then("User checks that keyword equals to {string}")
    public void checkThatKeywordEqualsToNameOfProduct(final String expectedValue) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(30);
        searchResultPage.waitVisibilityOfElement(30, searchResultPage.getProductTile());
        assertTrue(searchResultPage.getProductTitle().getAttribute("innerHTML").toUpperCase().contains(expectedValue.toUpperCase()));
    }

    @And("User clicks on a product from search result page to go to a product card page")
    public void clickOnProductFromResultSearchPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(30);
        searchResultPage.clickOnMascaraLink();
    }

    @And("User checks visibility of add to cart button")
    public void checkVisibilityOfAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(30);
        productPage.waitForAjaxToComplete(40);
        productPage.waitVisibilityOfElement(30, productPage.getProductPanelWithActionButtons());
        productPage.checkVisibilityOfAddToCartButton();
    }

    @And("User clicks on add to cart button")
    public void clickOnAddToCartButton() {
        productPage.clickOnAddToCartButton();
    }

    @Then("User checks that the number of products displayed in cart counter is {string}")
    public void checkTheNumberOfItemsInCartCounter(final String expectedNumberOfItems) {
        shippingCartPage = pageFactoryManager.getShippingCartPage();
        shippingCartPage.waitForPageLoadComplete(30);
        shippingCartPage.waitForAjaxToComplete(30);
        shippingCartPage.waitVisibilityOfElement(120, shippingCartPage.getTheNumberOfAddedItemsToCart());
        assertTrue(shippingCartPage.getTheNumberOfAddedItemsToCart().getText().equals(expectedNumberOfItems));
    }

    @And("User checks visibility of buy it now button")
    public void checkVisibilityOfBuyItNowButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(30);
        productPage.waitForAjaxToComplete(40);
        productPage.waitVisibilityOfElement(30, productPage.getProductPanelWithActionButtons());
        productPage.checkVisibilityOfBuyItNowButton();
    }

    @And("User clicks on buy it now button")
    public void clickOnBuyItNowButton() {
        productPage.clickOnBuyItNowButton();
    }

    @And("User checks visibility of checkout popup")
    public void checkVisibilityOfSingInPopup() {
        productPage.waitVisibilityOfElement(30, productPage.getSignInToCheckOutPopup());
        assertTrue(productPage.checkVisibilityOfSignInToCheckoutPopup());
    }

    @And("User clicks on checkout as guest button")
    public void clickOnCheckoutAsGuestButton() {
        productPage.waitVisibilityOfElement(30, productPage.getCheckOutAsGuestButton());
        productPage.clickOnCheckOutAsGuestButton();
    }

    @Then("User checks if checkout page is enabled for guest")
    public void checkIfCheckoutPageIsEnabledForGuest() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(30);
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getCheckoutPanel());
        assertTrue(checkoutPage.checkIfCheckoutPanelIsDisplayed());
    }

    @And("User clicks on product quantity field")
    public void clickOnProductQuantityField() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(30);
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getCheckoutPanel());
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getProductQuantityFieldWrapper());
        checkoutPage.clickOnProductQuantityField();
    }

    @And("User changes the number of items for checkout")
    public void clickOnSelectOptionValue() {
        checkoutPage.clickOnSelectOptionValue();
    }

    @Then("User checks that total to be paid in the cart on subtotal section is {string}")
    public void checkTheValueInSubtotalSection(final String expectedValue) {
        checkoutPage.waitForTextToBe(30, checkoutPage.getAmountOfItemsInCart(), "Items (2)");
        assertTrue(checkoutPage.getOrderTotalAmount().getAttribute("innerHTML").equals(expectedValue));
    }

    @And("User enters the name {string} into the input field")
    public void enterTheNameIntoTheInputField(final String name) {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(30);
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getCheckoutPanel());
        checkoutPage.fillInTheFirstNameInputField(name);
    }

    @And("User enters the lastname {string}")
    public void enterTheLastnameLastName(final String lastName) {
        checkoutPage.fillInTheLastNameInputField(lastName);
    }

    @And("User enters the city {string}")
    public void EntersTheCity(final String city) {
        checkoutPage.fillInCityInputField(city);
    }

    @And("User enters the street address {string}")
    public void enterTheStreetAddress(final String streetAddress) {
        checkoutPage.fillInStreetAddressInputField(streetAddress);
    }

    @And("User enters email {string}")
    public void enterEmail(final String email) {
        checkoutPage.fillInEmailInputField(email);
    }

    @And("User confirms email {string}")
    public void confirmEmail(final String email) {
        checkoutPage.fillInConfirmEmailInputField(email);
    }

    @And("User enters the phone {string} into input field")
    public void enterThePhoneNumberIntoInputField(final String phoneNumber) {
        checkoutPage.fillInPhoneNumberInputField(phoneNumber);
    }

    @And("User clicks on submit button")
    public void clickOnSubmitButton() {
        checkoutPage.clickOnSubmitButton();
    }

    @Then("User checks if summary ship to panel is displayed")
    public void checksIfSummaryShipToPanelIsDisplayed() {
        checkoutPage.waitForPageLoadComplete(30);
        checkoutPage.waitVisibilityOfElement(50, checkoutPage.getShipToAddressPanel());
        assertTrue(checkoutPage.isShipToAddressPanelIsDisplayed());
    }

    @Then("User checks that message {string} is displayed")
    public void checkThatErrorMessageIsDisplayed(final String message) {
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getErrorMessage());
        assertTrue(checkoutPage.getErrorMessage().getText().contains(message));
    }

    @Then("User checks that the next step is not available")
    public void checkThatTheNextStepOfCheckoutIsNotAvailable() {
       assertTrue(checkoutPage.checkIfPaymentPanelIsInactive());
    }

    @And("User checks the checkbox from the filter section")
    public void checkTheCheckboxFromTheFilterSection() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(30);
        searchResultPage.clickOnCheckBoxInFilterSection();
    }

    @Then("User checks that products have been filtered in accordance with the {string}")
    public void checkThatItemContainsTheFilterWord(final String filterWord) {
        searchResultPage.waitForPageLoadComplete(30);
        List<String> list = searchResultPage.getTheStringListOfProductResultSearch(searchResultPage.getListOfProductResultSearch());
        for(String s : list) {
            assertTrue(s.toLowerCase().contains(filterWord.toLowerCase()));
        }
    }

    @And("User enters the keyWord {string} into the search field")
    public void enterTheKeyWordIntoTheSearchField(final String keyWord2) {
        shippingCartPage = pageFactoryManager.getShippingCartPage();
        shippingCartPage.waitForPageLoadComplete(30);
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getSearchField());
        shippingCartPage.enterKeywordIntoTheSearchField(keyWord2);
    }

    @Then("User clicks on the search button")
    public void clicksOnSearchButton() {
        shippingCartPage.clickOnTheSearchButton();
    }

    @And("User clicks on a product from the search result page to go to a product card page")
    public void clickOnProductLink() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(30);
        searchResultPage.waitVisibilityOfElement(30, searchResultPage.getShampooLink());
        searchResultPage.clickOnShampooLink();
    }

    @Then("User checks that the amount of products in the Cart is {int}")
    public void checkTheAmountOfProductsInTheCart(int number) {
        shippingCartPage.waitForPageLoadComplete(30);
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getCartMainContent());
        int size = (shippingCartPage.getListOfProductsInCartString(shippingCartPage.getListOfProductsInCart())).size();
        assertEquals(size, number);
    }

    @Then("User removes the product from the cart")
    public void clickRemoveButtonInTheCart() {
        shippingCartPage = pageFactoryManager.getShippingCartPage();
        shippingCartPage.waitForPageLoadComplete(30);
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getCartMainContent());
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getRemoveLink());
        shippingCartPage.clickOnRemoveLink();
    }

    @Then("User checks that the cart is empty")
    public void checkTheCartIsEmpty() {
        shippingCartPage.waitForPageLoadComplete(30);
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getMessageAfterDeletion());
        shippingCartPage.waitVisibilityOfElement(30, shippingCartPage.getStartShoppingButton());
        assertTrue(shippingCartPage.checkVisibilityOfMessageAfterDeletion());
        assertTrue(shippingCartPage.checkVisibilityOfStartShoppingButton());
    }

    @And("User clicks on the second product from search result page to go to a product card page")
    public void clicksOnProductOnSearchResultPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(30);
        searchResultPage.clickOnMascaraLink2();
    }

    @And("User changes the number of items in the cart to maximum")
    public void changeTheNumberOfItems() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitVisibilityOfElement(30, checkoutPage.getSelectOptionValue2());
        checkoutPage.clickOnSelectOptionValue2();
    }

    @Then("User changes the number of items to {string}")
    public void changeTheNumberOfItems(final String number) {
        checkoutPage.waitForAjaxToComplete(30);
        checkoutPage.waitVisibilityOfElement(60, checkoutPage.getUpdateButton());
        checkoutPage.enterZeroNumberOfItems(number);
    }

    @And("User clicks on update button")
    public void clickOnUpdateButton() {
        checkoutPage.waitVisibilityOfElement(60, checkoutPage.getUpdateButton());
        checkoutPage.clickOnUpdateButton();
    }

    @Then("User checks that subtotal is not changed to zero")
    public void checkThatSubtotalIsNotChangedToZero() {
        checkoutPage.waitForAjaxToComplete(60);
        checkoutPage.waitVisibilityOfElement(60, checkoutPage.getAmountOfItemsInCart());
        checkoutPage.waitForAjaxToCompletePdp(60);
        assertTrue(checkoutPage.getAmountOfItemsInCart().getAttribute("innerHTML").contains(" Subtotal (1 item)"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
