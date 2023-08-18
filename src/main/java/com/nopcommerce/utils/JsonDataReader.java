package com.nopcommerce.utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    // Register New User Attributes
    public String firstName;
    public String lastName;
    public String userEmail;
    public String userPassword;
    public String userConfirmPassword;

    // User Billing Address Attributes
    public String country;
    public String city;
    public String address1;
    public String postalCode;
    public String phoneNumber;

    public JSONArray jsonDataReader(String filePath) throws IOException, ParseException {
        File srcFile = new File(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(srcFile));
        return jsonArray;
    }
    public void jsonReaderForUserRegistrationData() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/RegisterNewUserData.json";
        JSONArray jsonArray = jsonDataReader(filePath);
        for(Object jsonObject : jsonArray ){
            JSONObject newUserInfo = (JSONObject) jsonObject;
            firstName = (String)newUserInfo.get("firstName");
            lastName = (String)newUserInfo.get("lastName");
            userEmail = (String)newUserInfo.get("userEmail");
            userPassword = (String)newUserInfo.get("userPassword");
            userConfirmPassword = (String)newUserInfo.get("userConfirmPassword");
        }
    }
    public void jsonReaderForUserBillingAddressData() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserBillingAddressData.json";
        JSONArray jsonArray = jsonDataReader(filePath);
        for(Object jsonObject : jsonArray ){
            JSONObject newUserInfo = (JSONObject) jsonObject;
            country = (String)newUserInfo.get("country");
            city = (String)newUserInfo.get("city");
            address1 = (String)newUserInfo.get("address1");
            postalCode = (String)newUserInfo.get("postalCode");
            phoneNumber = (String)newUserInfo.get("phoneNumber");
        }
    }
}
