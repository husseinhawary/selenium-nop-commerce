package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    // Locators
    private By firstNameTxtBox = By.id("FirstName");
    private By lastNameTxtBox = By.id("LastName");
    private By emailTxtBox = By.id("Email");
    private By passwordTxtBox = By.id("Password");
    private By confirmPasswordTxtBox = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Register with firstname: {0}, lastname: {1}, email: {2}, password: {3}, confirm-password: {4} for method: {method} step...")
    public RegistrationResultPage userRegistrationWithRequiredFieldsOnly(String firstName, String lastName, String email, String password, String confirmPassword){
        log.info("Fill user registration required fields only then register");
        clearTextValue(firstNameTxtBox);
        setTextValue(firstNameTxtBox, firstName);
        clearTextValue(lastNameTxtBox);
        setTextValue(lastNameTxtBox, lastName);
        clearTextValue(emailTxtBox);
        setTextValue(emailTxtBox, email);
        clearTextValue(passwordTxtBox);
        setTextValue(passwordTxtBox, password);
        clearTextValue(confirmPasswordTxtBox);
        setTextValue(confirmPasswordTxtBox, confirmPassword);
        clickElement(registerBtn);
        return new RegistrationResultPage(driver);
    }
}
