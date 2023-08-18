package com.nopcommerce;

import com.nopcommerce.utils.JsonDataReader;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.nopcommerce.utils.Utils.getCurrentDateTime;

public class RegisterTests extends BaseTests{
    private JsonDataReader jsonDataReaderObj;

    @Test(description = "User Registration With Required Fields Only")
    @Description("User Registration With Required Fields Only")
    public void testUserRegistrationWithRequiredFieldsOnly() throws IOException, ParseException {
        log.info("User Registration With Required Fields Only");
        log.info("Read User Registration Data From RegisterNewUserData.json File");
        jsonDataReaderObj = new JsonDataReader();
        jsonDataReaderObj.jsonReaderForUserRegistrationData();
        log.info("Get current date-time and add it to user email to make sure it's unique every time");
        String currentDateTime = getCurrentDateTime();
        String userEmail = currentDateTime + jsonDataReaderObj.userEmail;
        String registrationMsg = homePage.openRegisterPage()
                .userRegistrationWithRequiredFieldsOnly(jsonDataReaderObj.firstName, jsonDataReaderObj.lastName, userEmail, jsonDataReaderObj.userPassword, jsonDataReaderObj.userConfirmPassword)
                .getRegistrationMsgText();
        Assert.assertEquals(registrationMsg, "Your registration completed", "Registration message is incorrect");
    }
}
