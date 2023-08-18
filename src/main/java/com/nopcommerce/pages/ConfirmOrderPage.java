package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage extends BasePage{
    // Locators
    private By confirmBtn = By.xpath("//div[@id='confirm-order-buttons-container']//button[text()='Confirm']");

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open confirm order page step...")
    public ThankYouPage confirmOrder(){
        log.info("Open confirm order page");
        waitUntilElementBeVisible(confirmBtn);
        clickElement(confirmBtn);
        return new ThankYouPage(driver);
    }
}
