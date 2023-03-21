package com.contacts.activity.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidator {
    private static final String EMAIL_REGEX =
            "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private static final String PHONE_NUMBER_REGEX =
            "\\d{3}-\\d{3}-\\d{4}";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
