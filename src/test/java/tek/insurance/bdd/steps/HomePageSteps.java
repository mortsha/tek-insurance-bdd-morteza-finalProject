package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.insurance.bdd.utility.SeleniumUtility;

public class HomePageSteps extends SeleniumUtility {



    @Then("home page title should be {string}")
    public void homePageTitleShouldBe(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("home page title should match ", expectedTitle, actualTitle);
    }





}
