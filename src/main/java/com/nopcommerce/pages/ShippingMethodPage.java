package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingMethodPage extends BasePage{
    //Locators
    private By shippingMethodContinueBtn = By.xpath("//div[@id='shipping-method-buttons-container']//button[text()='Continue']");
    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open shipping method page step...")
    public PaymentMethodPage selectGroundByDefaultShippingMethod(){
        log.info("Open shipping method page");
        waitUntilElementBeVisible(shippingMethodContinueBtn);
        clickElement(shippingMethodContinueBtn);
        return new PaymentMethodPage(driver);
    }
}
