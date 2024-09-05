package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import tek.insurance.bdd.pages.PlansPage;
import tek.insurance.bdd.utility.JavaUtility;
import tek.insurance.bdd.utility.SeleniumUtility;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;


public class PlansSteps extends SeleniumUtility {

    private static final Logger LOGGER = LogManager.getLogger(PlansPage.class);

    @Then("validate {int} row of data is present")
    public void validateRowOfDataIsPresent(int expectedTableRow) {
        List<WebElement> tableRows = getListOfElements(PlansPage.TABLE_ROW_LIST);
        Assert.assertEquals("Table row should match ", expectedTableRow, tableRows.size());
    }


    @Then("validate Date Created is todays date in EST Time Zone")
    public void validateDateCreatedIsTodaysDateInESTTimeZone() {
        List<WebElement> datesCreatedList = getListOfElements(PlansPage.DATE_CREATED_ELEMENTS);
        SoftAssert softAssert = new SoftAssert();
        LocalDate expectedTodayDate = LocalDate.now(JavaUtility.getESTZoneId());
        for (WebElement dateCreated : datesCreatedList) {
            try {
                LocalDate actualDateCreated = LocalDate.parse(getElementText(dateCreated), JavaUtility.dateTimeFormatter());
                softAssert.assertEquals(actualDateCreated, expectedTodayDate, "Created Date should match ");

            } catch (DateTimeParseException e) {
                LOGGER.debug("Error parsing date: " + e.getMessage());
                softAssert.fail("Date parsing failed for element: " + getElementText(dateCreated) + " - " + e.getMessage());
            }

        }
        softAssert.assertAll();
    }

    @Then("validate Date Expire is a day after EST Time Zone")
    public void validateDateExpireIsADayAfterESTTimeZone() {
        List<WebElement> datesExpireList = getListOfElements(PlansPage.DATE_EXPIRE_ELEMENTS);
        SoftAssert softAssert = new SoftAssert();
        LocalDate expectedExpireDate = LocalDate.now(JavaUtility.getESTZoneId()).plusDays(1);
        for (WebElement dateExpire : datesExpireList) {
            try {
                LocalDate actualDateExpire = LocalDate.parse(getElementText(dateExpire), JavaUtility.dateTimeFormatter());
                softAssert.assertEquals(actualDateExpire, expectedExpireDate, "Created Date should match ");

            } catch (DateTimeParseException e) {
                LOGGER.debug("Error parsing date: " + e.getMessage());
                softAssert.fail("Date parsing failed for element: " + getElementText(dateExpire) + " - " + e.getMessage());
            }

        }
        softAssert.assertAll();


    }


}
