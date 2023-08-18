package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutBillingAddressPage extends BasePage{
    // Locators
    private By countryDropDownList = By.id("BillingNewAddress_CountryId");
    private By cityTxtBox = By.id("BillingNewAddress_City");
    private By address1TxtBox = By.id("BillingNewAddress_Address1");
    private By postalCodeTxtBox = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberTxtBox = By.id("BillingNewAddress_PhoneNumber");
    private By continueBtn = By.xpath("//div[@id='billing-buttons-container']//button[text()='Continue']");;

    public CheckoutBillingAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open cart page step...")
    public ShippingMethodPage addBillingAddressWithRequiredFieldsOnly(String country, String city, String address1, String postalCode, String phoneNumber){
        log.info("Open billing address page");
        selectByVisibleText(countryDropDownList, country);
        setTextValue(cityTxtBox, city);
        setTextValue(address1TxtBox, address1);
        setTextValue(postalCodeTxtBox, postalCode);
        setTextValue(phoneNumberTxtBox, phoneNumber);
        clickElement(continueBtn);
        return new ShippingMethodPage(driver);
    }
}
