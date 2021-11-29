package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryScenarioPage extends BasePage {

    private static final By NAVBAR_FLOWER = By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/nav/ul/li[2]");
    private static final By CLOSE_BUTTON = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/a");
    private static final By CATEGORY_DROPDOWN = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/div/div[1]/div/a");
    private static final By PRICE_BUTTON = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/div/div[6]/a");
    private static final By PRICE_INPUT_MIN = By.id("min-price-filter");
    private static final By PRICE_INPUT_MAX = By.id("max-price-filter");
    private static final By PRICE_INPUT_OK = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/div/div[6]/div/div[1]/div[2]/div/button");
    private static final By BONSAI_INPUT = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/div/div[1]/div/div/div[1]/ul/li[2]/label");
    private static final By APPLY_BUTTON = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/div/div[1]/div/div/div[2]/button");
    private static final By CONTROL_TITLE = By.xpath("/html/body/main/div/div[4]/div[1]/div/div/a/div[2]/div[2]/p");
    private static final By CONTROL_PRICE = By.xpath("/html/body/main/div/div[4]/div[1]/div/div/a/div[2]/div/div[3]/div[2]/div[1]/span");


    public CategoryScenarioPage(WebDriver driver) {
        super(driver);
    }

    public CategoryScenarioPage clickFlowerButton() {
        clickElementBy(NAVBAR_FLOWER);
        return this;
    }

    public CategoryScenarioPage clickCLoseButton() {
        clickElementBy(CLOSE_BUTTON);
        return this;
    }

    public void clickBonsaiCategory() {
        clickElementBy(CATEGORY_DROPDOWN);
        clickElementBy(BONSAI_INPUT);
        waitClickable(APPLY_BUTTON);
        clickElementBy(APPLY_BUTTON);
    }

    public void clickPriceCategory() {
        clickElementBy(PRICE_BUTTON);
        toFillInputField(PRICE_INPUT_MIN, "50");
        toFillInputField(PRICE_INPUT_MAX, "150");
        clickElementBy(PRICE_INPUT_OK);
    }

    public Boolean getTitle(String searchWord) {
        return getText(CONTROL_TITLE).contains(searchWord);
    }

    public Integer getPriCe() {
        String price = getText(CONTROL_PRICE);
        return Integer.parseInt(price);
    }
}
