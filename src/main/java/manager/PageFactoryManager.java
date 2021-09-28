package manager;

import org.openqa.selenium.WebDriver;
import pages.*;


public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public ShippingCartPage getShippingCartPage() {
        return new ShippingCartPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }
}
