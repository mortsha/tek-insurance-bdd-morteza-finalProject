package tek.insurance.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import tek.insurance.bdd.pages.CreateNewAccountPage;
import tek.insurance.bdd.pages.HomePage;
import tek.insurance.bdd.pages.ProfilePage;
import tek.insurance.bdd.pages.SignUpPage;
import tek.insurance.bdd.utility.DataGenerator;
import tek.insurance.bdd.utility.JavaUtility;
import tek.insurance.bdd.utility.SeleniumUtility;

import java.util.Map;


public class CreateNewAccountSteps extends SeleniumUtility {

    private static final Logger LOGGER = LogManager.getLogger(CreateNewAccountSteps.class);
    private String randomEmailGenerated;
    public static String usernameCreatedAccount;
    public static String fullNameCreatedAccount;

    @When("user click on {string} link")
    public void userClickOnLink(String string) {
        clickOnElement(HomePage.CREATE_PRIMARY_ACCOUNT_LINK);
    }


    @When("user fill the create new account form")
    public void userFillTheCreateNewAccountForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        String emailAddress = data.get("EmailAddress");
        String firstName = data.get("FirstName");
        String gender = data.get("Gender");
        String employmentStatus = data.get("EmploymentStatus");
        String title = data.get("Title");
        String lastName = data.get("LastName");
        String maritalStatus = data.get("MaritalStatus");
        String dateOfBirth = data.get("DateOfBirth");
        randomEmailGenerated = DataGenerator.getRandomEmail(firstName);

        fullNameCreatedAccount = JavaUtility.getFirstCharacterCapital(firstName) + " " + JavaUtility.getFirstCharacterCapital(lastName);

        String emailToUse = emailAddress.equalsIgnoreCase("random") ? randomEmailGenerated : emailAddress;
        usernameCreatedAccount = emailToUse.substring(0, emailToUse.indexOf("@"));

        sendText(CreateNewAccountPage.EMAIL_INPUT, emailToUse);
        sendText(CreateNewAccountPage.FIRST_NAME_INPUT, firstName);
        sendText(CreateNewAccountPage.EMPLOYMENT_STATUS_INPUT, employmentStatus);
        sendText(CreateNewAccountPage.LAST_NAME_INPUT, lastName);
        sendText(CreateNewAccountPage.DATE_OF_BIRTH_INPUT, dateOfBirth);

        selectDropdownByText(CreateNewAccountPage.GENDER_DROPDOWN, gender);
        selectDropdownByText(CreateNewAccountPage.TITLE_DROPDOWN, title);
        selectDropdownByText(CreateNewAccountPage.MARITAL_STATUS_DROPDOWN, maritalStatus);

    }

    @Then("validate email shows as expected in sign up page")
    public void validateEmailShowsAsExpectedInSignUpPage() {
        String actualEmail = getElementText(SignUpPage.EMAIL_CREATED);
        Assert.assertEquals("Email created should match ", randomEmailGenerated, actualEmail);
    }

    @Then("validate error message as expected for email {string}")
    public void validateErrorMessageAsExpectedForEmail(String existingEmail) {
        String expectedErrorMessage = "Account with email " + existingEmail + " is exist";
        String errorActual = getElementText(CreateNewAccountPage.ERROR_MESSAGE);
        String actualErrorMessage = errorActual.replace("ERROR", "").trim();

        Assert.assertEquals("Error message should match ", expectedErrorMessage, actualErrorMessage);

    }

    @Then("validate error message as expected {string}")
    public void validateErrorMessageAsExpected(String expectedErrorMessage) {
        String actualError = getElementText(CreateNewAccountPage.ERROR_MESSAGE);
        String actualErrorMessage = actualError.replace("ERROR", "").trim();
        Assert.assertEquals("Error message should match ", expectedErrorMessage, actualErrorMessage);
    }

    @When("user wait {int} seconds to redirect to sign in page")
    public void userWaitSecondsToRedirectToSignInPage(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }


    @When("validate full name displayed at Profile Section")
    public void validateFullNameDisplayedAtProfileSection() {
        String actualFullName = getElementText(ProfilePage.FULL_NAME);
        Assert.assertEquals("Profile full name should match ", fullNameCreatedAccount, actualFullName);
    }


}
