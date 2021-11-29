package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement toFindElement(By by, int... index) {
        waitAppears(by);
        return index.length == 0
                ? driver.findElement(by)
                : driver.findElements(by).get(index[0]);
    }

    protected void clickElementBy(By by, int... index) {
        WebElement element = index.length == 0
                ? toFindElement(by)
                : toFindElement(by, index[0]);
        highlight(element);
        element.click();
    }

    protected WebElement toFillInputField(By by, String text) {
        WebElement element = toFindElement(by);
        highlight(element);
        clearElement(by);
        element.sendKeys(text);
        return element;
    }

    protected void clearElement(By by) {
        WebElement element = toFindElement(by);
        element.click();
        element.clear();
    }

    protected String getText(By by, int... index) {
        return index.length == 0
                ? toFindElement(by).getText()
                : toFindElement(by, index[0]).getText();
    }

    protected void waitAppears(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    protected void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }
}