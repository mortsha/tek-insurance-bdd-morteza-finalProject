package tek.insurance.bdd.pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.insurance.bdd.utility.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {

    @Before
    public void beforeEachScenario() {
        setupBrowser();
    }

    @After
    public void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = getScreenShot();
            scenario.attach(screenshot, "image/ping", "failed_scenario");
        }

        quitBrowser();
    }

}
