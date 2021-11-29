package test;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CategoryScenarioPage;

public class CategoryScenarioTest extends BaseTest {
    private static CategoryScenarioPage osp;

    @BeforeClass()
    public void before() {
        logger = LogManager.getLogger(CategoryScenarioTest.class.getName());
        logger.info(TEST_STARTED);
        osp = new CategoryScenarioPage(getDriver());
    }

    @Test(priority = 1)
    public void checkCategoryFilter() throws InterruptedException {
        osp.clickCLoseButton()
                .clickFlowerButton()
                .clickBonsaiCategory();
        Thread.sleep(5000);
        Assert.assertTrue(osp.getTitle("Bonsai"));
    }

    @Test(priority = 2)
    public void checkPriceFilter() throws InterruptedException {
        osp.clickFlowerButton()
                .clickPriceCategory();
        Thread.sleep(5000);
        Assert.assertTrue(controlPrice());
    }

    @AfterClass()
    public void after() {
        logger.info("Test Ended" + "\n");
    }

    private Boolean controlPrice() {
        Integer controlPrice = osp.getPriCe();
        System.out.println(controlPrice);
        return controlPrice < 150 && controlPrice >= 50;
    }
}