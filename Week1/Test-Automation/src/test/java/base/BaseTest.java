package base;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Map;


public class BaseTest extends DriverFactory {
    protected static final String TEST_STARTED = "Test started";
    private static final Map<Integer, String> testResultMap = Map.of(1, "PASS", 2, "FAIL", 3, "SKIP");
    private static final String failure = testResultMap.get(2);
    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void startUp(ITestContext context) {
        createDriver();
        getDriver().get("https://www.ciceksepeti.com/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(ITestContext context) {
        getDriver().quit();
    }

    @AfterMethod()
    public void afterTest(ITestResult result, ITestContext context, Method testMethod) {
        if (result.getName() != null) {
            String testResult = testResultMap.getOrDefault(result.getStatus(), failure);
            logger.info(result.getName() + " result is " + testResult);
        }
    }
}
