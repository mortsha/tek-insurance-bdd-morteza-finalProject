package tek.insurance.bdd.pages;

import org.openqa.selenium.By;

public class CreateNewAccountPage {

    public static final By CREATED_PRIMARY_ACCOUNT_HOLDER_HEADER = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By FIRST_NAME_INPUT = By.id("firstName");
    public static final By GENDER_DROPDOWN = By.id("gender");
    public static final By EMPLOYMENT_STATUS_INPUT = By.id("employmentStatus");
    public static final By TITLE_DROPDOWN = By.id("title");
    public static final By LAST_NAME_INPUT = By.id("lastName");
    public static final By MARITAL_STATUS_DROPDOWN = By.id("maritalStatus");
    public static final By DATE_OF_BIRTH_INPUT = By.id("dateOfBirth");

    public static final By ERROR_MESSAGE = By.className("chakra-alert");
//    public static final By ERROR_MESSAGE = By.xpath("//div[starts-with(@class,'chakra-alert')]//child::div");


}
