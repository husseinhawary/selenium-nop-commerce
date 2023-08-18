package com.nopcommerce.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getCurrentDateTime(){
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }
}