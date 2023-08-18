package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    // Locators
    private By emailTxtBox = By.id("Email");
    private By passwordTxtBox = By.id("Password");
    private By loginBtn = By.xpath("//button[@type='submit' and text()='Log in']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with user-email: {0}, user-password: {1} for method: {method} step...")
    public HomePage userLoginWithValidData(String userEmail, String userPassword){
        log.info("Fill user login fields with valid data and click on login button");
        clearTextValue(emailTxtBox);
        setTextValue(emailTxtBox, userEmail);
        clearTextValue(passwordTxtBox);
        setTextValue(passwordTxtBox, userPassword);
        clickElement(loginBtn);
        return new HomePage(driver);
    }
}
