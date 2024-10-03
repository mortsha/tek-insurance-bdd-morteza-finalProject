package tek.insurance.bdd.pages;

import org.openqa.selenium.By;

public class AccountsPage {

    public static final By ACCOUNT_HEADER_TITLE = By.xpath("//div[contains(@class,'header')]//a//following-sibling::h2");

    public static final By DATA_TABLE_ROW_LIST = By.xpath("//table/tbody/tr");
    public static final By SHOW_RECORD_DROPDOWN = By.xpath("//div[starts-with(@class,'chakra-select__wrapper')]//child::select");

}
