package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.insurance.bdd.pages.AccountsPage;
import tek.insurance.bdd.pages.CreateNewAccountPage;
import tek.insurance.bdd.utility.SeleniumUtility;

public class LoginSteps extends SeleniumUtility {


    @Then("validate the error message as expected {string}")
    public void validateTheErrorMessageAsExpected(String expectedError) {
        String actualError = getElementText(CreateNewAccountPage.ERROR_MESSAGE);
        String actualErrorMessage = actualError.replace("ERROR", "").trim();
        Assert.assertEquals("Error message should match ", expectedError, actualErrorMessage);


    }


    @Then("validate {string} account title")
    public void validateAccountTitle(String expectedHeader) {
        String actualHeader = getElementText(AccountsPage.ACCOUNT_HEADER_TITLE);
        Assert.assertEquals("Header should match ", expectedHeader, actualHeader);
    }


}
