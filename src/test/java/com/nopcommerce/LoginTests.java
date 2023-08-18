package com.nopcommerce;
import com.nopcommerce.utils.JsonDataReader;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static com.nopcommerce.utils.Utils.getCurrentDateTime;

public class LoginTests extends BaseTests{
    private JsonDataReader jsonDataReaderObj;

    @Test(description = "User Login With Valid Data")
    @Description("User Login With Valid Data")
    public void testUserLoginWithValidData() throws IOException, ParseException {
        log.info("Read User Registration Data From RegisterNewUserData.json File");
        jsonDataReaderObj = new JsonDataReader();
        jsonDataReaderObj.jsonReaderForUserRegistrationData();
        log.info("Get current date-time and add it to user email to make sure it's unique every time");
        String currentDateTime = getCurrentDateTime();
        String userEmail = currentDateTime + jsonDataReaderObj.userEmail;
        homePage.openRegisterPage()
                .userRegistrationWithRequiredFieldsOnly(jsonDataReaderObj.firstName, jsonDataReaderObj.lastName, userEmail, jsonDataReaderObj.userPassword, jsonDataReaderObj.userConfirmPassword);
        log.info("Login With The Newly Registered User");
        var logoutLinkValue = homePage.openLoginPage()
               .userLoginWithValidData(userEmail, jsonDataReaderObj.userPassword)
               .getLogoutLinkText();
        Assert.assertEquals(logoutLinkValue, "Log out", "Log out link is incorrect");
    }
}
