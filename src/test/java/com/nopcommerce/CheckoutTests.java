package com.nopcommerce;
import com.nopcommerce.utils.JsonDataReader;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.nopcommerce.utils.Utils.getCurrentDateTime;

public class CheckoutTests extends BaseTests{
    private JsonDataReader jsonDataReaderObj;

    @Test(description = "Checkout order")
    @Description("Checkout order cycle")
    public void testCheckoutOrder() throws IOException, ParseException, InterruptedException {
        log.info("This scenario contains the full e2e cycle from registration to placing the order");
        log.info("Read User Registration Data From RegisterNewUserData.json File");
        jsonDataReaderObj = new JsonDataReader();
        jsonDataReaderObj.jsonReaderForUserRegistrationData();
        jsonDataReaderObj.jsonReaderForUserBillingAddressData();
        log.info("Get current date-time and add it to user email to make sure it's unique every time");
        String currentDateTime = getCurrentDateTime();
        String userEmail = currentDateTime + jsonDataReaderObj.userEmail;
        homePage.openRegisterPage()
                .userRegistrationWithRequiredFieldsOnly(jsonDataReaderObj.firstName, jsonDataReaderObj.lastName, userEmail, jsonDataReaderObj.userPassword, jsonDataReaderObj.userConfirmPassword);
        log.info("Login With The Newly Registered User");
        homePage.openLoginPage()
                .userLoginWithValidData(userEmail, jsonDataReaderObj.userPassword);
        log.info("Add Item To Cart");
        homePage.openBooksPage()
                .sortBooksByPriceFromLowToHigh()
                .addBookToCartByIndex(1);
        log.info("Checkout order cycle till confirmation");
        var actualResult = homePage.openCartPage().
                openCheckoutBillingAddressPage()
                .addBillingAddressWithRequiredFieldsOnly(jsonDataReaderObj.country, jsonDataReaderObj.city, jsonDataReaderObj.address1, jsonDataReaderObj.postalCode, jsonDataReaderObj.phoneNumber)
                .selectGroundByDefaultShippingMethod().selectMoneyOrderByDefaultPaymentMethod()
                .confirmPaymentInformation().confirmOrder().getThankYouMessage();
        Assert.assertEquals(actualResult, "Thank you", "Incorrect thank you message");
    }
}
