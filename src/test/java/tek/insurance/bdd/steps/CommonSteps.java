package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.insurance.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {

    @When("user click on {string} link")
    public void userClickOnLink(String expectedLinkText) {
        clickOnElement(By.linkText(expectedLinkText));
    }

    @Then("validate {string} title")
    public void validateTitle(String expectedHeader) {
        String xpath = "//h2[text()='" + expectedHeader + "']";
        String actualHeader = getElementText(By.xpath(xpath));
        Assert.assertEquals("Header should match ", expectedHeader, actualHeader);
    }

    @Then("the {string} link is displayed")
    public void theLinkIsDisplayed(String linkText) {
        Assert.assertTrue(isDisplayed(getWebElement(By.linkText(linkText))));

    }


    @Then("user click on {string} button")
    public void userClickOnButton(String expectedButton) {
        if(expectedButton.equalsIgnoreCase("Profile")){
            clickOnElement(By.xpath("//button[@aria-label='profile']"));
        }else {
            String xpath = "//button[text()='" + expectedButton + "']";
            clickOnElement(By.xpath(xpath));
        }

    }


    @When("user enter {string} on field {string}")
    public void userEnterOnField(String value, String field) {
        recordData.put(field,value);
        if(value.equalsIgnoreCase("username")){
            sendText(By.name(field.toLowerCase()),CreateNewAccountSteps.usernameCreatedAccount);
        }else {
            sendText(By.name(field.toLowerCase()), value);
        }

    }

}
