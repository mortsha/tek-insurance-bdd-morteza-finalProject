package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.insurance.bdd.pages.AccountsPage;
import tek.insurance.bdd.utility.SeleniumUtility;

import java.util.List;

public class AccountsSteps extends SeleniumUtility {

    @Then("the default number of records per page should be {int}")
    public void theDefaultNumberOfRecordsPerPageShouldBe(int expectedRecord) {
        List<WebElement> allRecord = getListOfElements(AccountsPage.DATA_TABLE_ROW_LIST);
        int expectedRecordShow = allRecord.size();
        Assert.assertEquals("Table record default per page should match", expectedRecord, expectedRecordShow);
    }


    @When("the user selects to show {int} records per page")
    public void theUserSelectsToShowRecordsPerPage(int actualSelectRecord) {
        String actualSelectRecordToString = String.valueOf(actualSelectRecord);
        selectDropDownByValue(AccountsPage.SHOW_RECORD_DROPDOWN, actualSelectRecordToString);
    }

    @Then("exactly {int} records should be displayed on the page")
    public void exactlyRecordsShouldBeDisplayedOnThePage(int expectedTableRow) {
        List<WebElement> allRecord = getListOfElements(AccountsPage.DATA_TABLE_ROW_LIST);
        int expectedRecordShow = allRecord.size();
        Assert.assertEquals("Table record default per page should match", expectedTableRow, expectedRecordShow);

    }


}
