package com.nopcommerce;
import com.nopcommerce.utils.JsonDataReader;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.nopcommerce.utils.Utils.getCurrentDateTime;

public class BooksTests extends BaseTests {
    private JsonDataReader jsonDataReaderObj;

    @Test(description = "Add the second book to cart after sorting")
    @Description("Add the second book to cart after sorting by Price: Low to High")
    public void addSecondBookToCartAfterSortingPriceLowToHigh() throws IOException, ParseException, InterruptedException {
        log.info("Read User Registration Data From RegisterNewUserData.json File");
        jsonDataReaderObj = new JsonDataReader();
        jsonDataReaderObj.jsonReaderForUserRegistrationData();
        log.info("Get current date-time and add it to user email to make sure it's unique every time");
        String currentDateTime = getCurrentDateTime();
        String userEmail = currentDateTime + jsonDataReaderObj.userEmail;
        homePage.openRegisterPage()
                .userRegistrationWithRequiredFieldsOnly(jsonDataReaderObj.firstName, jsonDataReaderObj.lastName, userEmail, jsonDataReaderObj.userPassword, jsonDataReaderObj.userConfirmPassword);
        log.info("Login With The Newly Registered User");
        homePage.openLoginPage()
                .userLoginWithValidData(userEmail, jsonDataReaderObj.userPassword);
        log.info("Add Item To Cart");
        var addItemToCartSuccessMessage = homePage.openBooksPage()
                .sortBooksByPriceFromLowToHigh()
                .addBookToCartByIndex(1)
                .getAddItemToCartSuccessMessage();
        Assert.assertTrue(addItemToCartSuccessMessage.contains("The product has been added to your"), "Add book to cart success message is incorrect");
    }
}
