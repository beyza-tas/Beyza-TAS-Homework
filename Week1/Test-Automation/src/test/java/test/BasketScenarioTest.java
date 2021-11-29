package test;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BasketScenarioPage;

public class BasketScenarioTest extends BaseTest {
    private static BasketScenarioPage bsp;

    @BeforeClass()
    public void before() {
        logger = LogManager.getLogger(CategoryScenarioTest.class.getName());
        logger.info(TEST_STARTED);
        bsp = new BasketScenarioPage(getDriver());
    }

    @Test(priority = 1)
    public void checkBasketAdd() throws InterruptedException {
        bsp.clickCLoseButton()
                .clickHouseButton();
        Thread.sleep(5000);
        bsp.clickLightingButton()
                .clickProductButton(64)
                .clickBasketAddButton()
                .clickGoToButton();
        Thread.sleep(5000);
        bsp.clickHouseButton();
        Thread.sleep(5000);
        bsp.clickLightingButton()
                .clickProductButton(65)
                .clickBasketAddButton();
        Thread.sleep(5000);
        Assert.assertTrue(bsp.controlText(2, "1. Ürün"));
        Assert.assertTrue(bsp.controlText(3, "2. Ürün"));
    }

    @Test(priority = 2)
    public void checkTotalPrice() throws InterruptedException {
        Float priceOne = bsp.getPrice(2);
        Float priceTwo = bsp.getPrice(3);
        Float totalPrice = priceOne + priceTwo;
        Assert.assertEquals(totalPrice, bsp.getTotalPrice());
    }

    @AfterClass()
    public void after() {
        logger.info("Test Ended" + "\n");
    }

}