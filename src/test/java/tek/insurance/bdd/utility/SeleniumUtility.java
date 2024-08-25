package tek.insurance.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.insurance.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    private WebElement waitToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement waitTillVisible(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitTillVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public byte[] getScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
}
