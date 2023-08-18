package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPage extends BasePage{
    // Locators
    private By paymentMethodContinueBtn = By.xpath("//div[@id='payment-method-buttons-container']//button[text()='Continue']");

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open payment method page step...")
    public PaymentInformationPage selectMoneyOrderByDefaultPaymentMethod(){
        log.info("Open payment method page");
        waitUntilElementBeVisible(paymentMethodContinueBtn);
        clickElement(paymentMethodContinueBtn);
        return new PaymentInformationPage(driver);
    }
}
