package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    // Locators
    private By termsOfServiceCheckBox = By.id("termsofservice");
    private By checkoutBtn = By.id("checkout");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open billing cart address page step...")
    public CheckoutBillingAddressPage openCheckoutBillingAddressPage(){
        log.info("Open billing address page");
        waitUntilElementBeVisible(checkoutBtn);
        clickElement(termsOfServiceCheckBox);
        clickElement(checkoutBtn);
        return new CheckoutBillingAddressPage(driver);
    }
}
