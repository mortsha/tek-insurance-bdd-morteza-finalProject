package tek.insurance.bdd.pages;

import org.openqa.selenium.By;

public class SignUpPage {
    public static final By EMAIL_CREATED = By.xpath("//h2[text()='Sign up your account']//following-sibling::h2[2]");

    public static final By USER_NAME_INPUT = By.name("username");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By CONFIRM_PASSWORD_INPUT = By.name("confirm");

}
