package tek.insurance.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.insurance.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

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

    public void clickOnElement(WebElement element) {
        waitToBeClickable(element).click();
        LOGGER.info("Clicking on Element {} ", element);
    }

    public void clickOnElement(By locator) {
        waitToBeClickable(locator).click();
        LOGGER.info("Clicking on Locator {} ", locator);
    }

    public boolean isDisplayed(WebElement element) {
        LOGGER.info("Element displayed {} ", element);
        return waitTillVisible(element).isDisplayed();
    }

    public WebElement getWebElement(By locator) {
        LOGGER.info("getting title {} ", locator);
        return getDriver().findElement(locator);

    }

    public String getElementText(WebElement element) {
        LOGGER.info("Getting Element text {} ", element);
        return waitTillVisible(element).getText();
    }
    public String getElementText(By locator) {
        LOGGER.info("Getting Element text {} ", locator);
        return waitTillVisible(locator).getText();
    }

    public void sendText(By locator, String value) {
        LOGGER.info("Sending text {} to element {} ", value, locator);
        WebElement targetElement = waitTillVisible(locator);
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public void selectDropdownByText(By locator, String text) {
        WebElement dropdownElement = getDriver().findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }
    public List<WebElement> getListOfElements(By locator){
        return getDriver().findElements(locator);
    }
}
