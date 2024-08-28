package tek.insurance.bdd.pages;

import org.openqa.selenium.By;

public class ProfilePage {

    public static final By FULL_NAME = By.xpath("//p[text()='FULL NAME']//following-sibling::p");
    public static final By STATUS = By.xpath("//p[text()='STATUS']//following-sibling::p");
    public static final By USER_TYPE = By.xpath("//p[text()='USER TYPE']//following-sibling::p");
    public static final By USER_NAME = By.xpath("//p[text()='USERNAME']//following-sibling::p");
    public static final By AUTHORITIES = By.xpath("//p[text()='AUTHORITIES']//following-sibling::ul");



}
