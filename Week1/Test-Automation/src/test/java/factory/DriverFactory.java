package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final int DEFAULT_WAIT = 15;
    public static WebDriver driver;

    protected static void createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    protected static WebDriver getDriver() {
        return driver;
    }
}