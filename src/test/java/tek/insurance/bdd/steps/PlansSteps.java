package tek.insurance.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.insurance.bdd.pages.PlansPage;
import tek.insurance.bdd.utility.SeleniumUtility;

import java.util.List;
import java.util.WeakHashMap;

public class PlansSteps extends SeleniumUtility {


    @Then("validate {int} row of data is present")
    public void validateRowOfDataIsPresent(int expectedTableRow) {
        List<WebElement> tableRows = getListOfElements(PlansPage.TABLE_ROW_LIST);
        Assert.assertEquals("Table row should match ",expectedTableRow,tableRows.size());
    }

}
