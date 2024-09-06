package tek.insurance.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tek.insurance.bdd.browsers.BaseBrowser;
import tek.insurance.bdd.browsers.ChromeBrowser;
import tek.insurance.bdd.browsers.EdgeBrowser;
import tek.insurance.bdd.browsers.FirefoxBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseSetup {
    private static WebDriver driver;
    private final Properties properties;
    protected static final long WAIT_TIME_IN_SECONDS = 20;
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    public static Map<String, String> recordData = new HashMap<>();

    public static WebDriver getDriver() {
        return driver;
    }

    public BaseSetup() {

        try {

            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-config.properties";
            LOGGER.debug("Reading config file {}" , configFilePath);
            FileInputStream inputStream = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.debug("Error reading config file: " , e);
            throw new RuntimeException("Something wrong with config file, " , e);
        }


    }

    public void setupBrowser() {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.debug("Running on browser {} and isHeadless {} ", browserType, isHeadless);

        BaseBrowser browser;
        if (browserType.equalsIgnoreCase("chrome")) {
            browser = new ChromeBrowser();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            browser = new FirefoxBrowser();
        } else if (browserType.equalsIgnoreCase("edge")) {
            browser = new EdgeBrowser();
        } else
            throw new RuntimeException("Wrong browser type, choose chrome,firefox or edge");

        driver = browser.openBrowser(isHeadless);
        String url = properties.getProperty("ui.url");
        LOGGER.debug("Opening url {} ", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECONDS));


    }

    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }

    }
}
