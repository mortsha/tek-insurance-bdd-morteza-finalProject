package tek.insurance.bdd.pages;

import org.openqa.selenium.By;

public class PlansPage {

    public static final By TABLE_ROW_LIST = By.xpath("//table[contains(@class,'chakra-table')]/tbody/tr");




    public static final By MOTOR_DATE_CREATED = By.xpath("//table/tbody/tr[1]/td[4]");
    public static final By MOTOR_DATE_EXPIRE = By.xpath("//table/tbody/tr[1]/td[5]");

    public static final By DATE_CREATED_ELEMENTS = By.xpath(" //table/tbody/tr/td[4]");
    public static final By DATE_EXPIRE_ELEMENTS = By.xpath(" //table/tbody/tr/td[5]");


}
