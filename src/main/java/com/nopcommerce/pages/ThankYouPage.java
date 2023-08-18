package com.nopcommerce.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage extends BasePage{
    // Locators
    private By thankYouH1 = By.xpath("//div[@class='page checkout-page order-completed-page']//h1");
    public ThankYouPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open thank you page step...")
    public String getThankYouMessage(){
        log.info("Open thank you page");
        waitUntilElementBeVisible(thankYouH1);
        return getElementText(thankYouH1);
    }
}
