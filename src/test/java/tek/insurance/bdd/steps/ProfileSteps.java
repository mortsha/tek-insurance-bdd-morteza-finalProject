package tek.insurance.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.insurance.bdd.pages.ProfilePage;
import tek.insurance.bdd.utility.SeleniumUtility;
import java.util.Map;

public class ProfileSteps extends SeleniumUtility {

    @Then("validate information in profile side drawer")
    public void validateInformationInProfileSideDrawer(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();

        String actualStatus = getElementText(ProfilePage.STATUS);
        String expectedStatus = data.get("STATUS");
        Assert.assertEquals("information should match", expectedStatus, actualStatus);

        String actualUserType = getElementText(ProfilePage.USER_TYPE);
        String expectedUserType = data.get("USER TYPE");
        Assert.assertEquals("information should match", expectedUserType, actualUserType);

        String actualFullName = getElementText(ProfilePage.FULL_NAME);
        String expectedFullName = data.get("FULL NAME");
        Assert.assertEquals("information should match", expectedFullName, actualFullName);

        String actualUsername = getElementText(ProfilePage.USER_NAME);
        String expectedUsername = data.get("USERNAME");
        Assert.assertEquals("information should match", expectedUsername, actualUsername);

        String actualAuth = getElementText(ProfilePage.AUTHORITIES);
        String expectedAuth = data.get("AUTHORITIES");
        Assert.assertEquals("information should match", expectedAuth, actualAuth);


    }

}
