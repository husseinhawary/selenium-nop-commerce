package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationResultPage extends BasePage{

    // Locators
    private By registrationMsg = By.cssSelector(".page-body .result");
    public RegistrationResultPage(WebDriver driver) {
        super(driver);
    }
    @Step("Get registration message step...")
    public String getRegistrationMsgText(){
        log.info("Get registration message");
        waitUntilElementBeVisible(registrationMsg);
        return getElementText(registrationMsg);
    }
}
