package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInformationPage extends BasePage{
    // Locators
    private By paymentInformationContinueBtn = By.xpath("//div[@id='payment-info-buttons-container']//button[text()='Continue']");

    public PaymentInformationPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open payment information page step...")
    public ConfirmOrderPage confirmPaymentInformation(){
        log.info("Open payment information page");
        waitUntilElementBeVisible(paymentInformationContinueBtn);
        clickElement(paymentInformationContinueBtn);
        return new ConfirmOrderPage(driver);
    }
}
