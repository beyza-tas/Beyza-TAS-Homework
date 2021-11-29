package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketScenarioPage extends BasePage {
    private static final By CLOSE_BUTTON = By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/a");
    private static final By NAVBAR_HOUSE = By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/nav/ul/li[5]/span/a/span[2]");
    private static final By LIGHTING_CATEGORY = By.xpath("/html/body/main/div[1]/div[1]/div/div/div/div/div[3]/div/div");
    private static final By BASKET_ADD_BUTTON = By.xpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[14]/div[5]/button");
    private static final By GOTO_SHOP = By.xpath("//*[@id=\"shoppingCartForm\"]/div/div/div[2]/a");
    private static final By TOTAL_PRICE = By.xpath("/html/body/main/div[1]/div[2]/div/div[2]/div/div[7]/div/div[2]");


    public BasketScenarioPage(WebDriver driver) {
        super(driver);
    }

    public BasketScenarioPage clickCLoseButton() {
        clickElementBy(CLOSE_BUTTON);
        return this;
    }

    public BasketScenarioPage clickHouseButton() {
        clickElementBy(NAVBAR_HOUSE);
        return this;
    }

    public BasketScenarioPage clickLightingButton() {
        clickElementBy(LIGHTING_CATEGORY);
        return this;
    }

    public BasketScenarioPage clickProductButton(int number) {
        clickElementBy(By.xpath("/html/body/main/div/div[4]/div[" + number + "]/div"));
        return this;
    }

    public Boolean controlText(int number, String searchWord) {
        return getText(By.xpath("//*[@id=\"shoppingCartForm\"]/div/div/div[1]/div[" + number + "]/div/h3")).contains(searchWord);
    }

    public Float getPrice(int number) {
        String price = getText(By.xpath("//*[@id=\"shoppingCartForm\"]/div/div/div[1]/div[" + number + "]/div/div/div/div[2]/span[2]"));
        System.out.println(price);
        String[] priceArray = price.split(" ");
        return Float.parseFloat(priceArray[0].replace(",", "."));
    }

    public Float getTotalPrice() {
        String totalPrice = getText(TOTAL_PRICE);
        System.out.println(totalPrice);
        String[] priceArray = totalPrice.split(" ");
        String[] priceArray2 = priceArray[0].split("\n");
        return Float.parseFloat(priceArray2[0].replace(",", "."));
    }

    public BasketScenarioPage clickBasketAddButton() {
        clickElementBy(BASKET_ADD_BUTTON);
        return this;
    }

    public BasketScenarioPage clickGoToButton() {
        clickElementBy(GOTO_SHOP);
        return this;
    }

}
