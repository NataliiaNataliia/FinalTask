package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//li[@data-view='mi:1686|iid:1']")
    private WebElement productTileWithImageAndDescription;

    @FindBy(xpath = "//li[@data-view='mi:1686|iid:1']//h3[contains(@class,'s-item')]")
    private WebElement productTitleWithDescription;

    @FindBy(xpath = "//div[contains(@class,'info clearfix')]/a[contains(@href,'20356199')]")
    private WebElement mascaraLink;

    @FindBy(xpath = "//span[contains(@class,'checkbox ')]/input[@aria-label='Shampoo']")
    private WebElement checkBoxInFilterSection;

    @FindBy(xpath = "//div[contains(@class,'clearfix')]/a[@class='s-item__link']")
    private List<WebElement> listOfProductResultSearch;

    @FindBy(xpath = "//div[contains(@class,'clearfix')]/a[contains(@href,'402836556416')]")
    private WebElement shampooLink;

    @FindBy(xpath = "//div[contains(@class,'info clearfix')]/a[contains(@href,'492476')]")
    private WebElement mascaraLink2;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductTile() {
        return productTileWithImageAndDescription;
    }

    public WebElement getProductTitle() {
        return productTitleWithDescription;
    }

    public void clickOnMascaraLink() {
        mascaraLink.click();
    }

    public void clickOnCheckBoxInFilterSection() {
        checkBoxInFilterSection.click();
    }

    public List<WebElement> getListOfProductResultSearch() {
        return listOfProductResultSearch;
    }

    public List<String> getTheStringListOfProductResultSearch(List<WebElement> list) {
        return list.stream().map(i -> i.getText()).filter(i -> !i.isEmpty()).collect(Collectors.toList());
    }

    public void clickOnShampooLink() {
        shampooLink.click();
    }

    public WebElement getShampooLink() {
        return shampooLink;
    }

    public void clickOnMascaraLink2() {
        mascaraLink2.click();
    }
}
