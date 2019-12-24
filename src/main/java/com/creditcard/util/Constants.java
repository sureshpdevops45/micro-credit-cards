package com.creditcard.util;

import java.util.Random;

public final class Constants {

    private Constants() {

    }

    public static final String CREDIT_CARD_STARTING_NUMBER = "1001";

    private static Random random = new Random(System.currentTimeMillis());

    public static final String SUCCESS = "Success";
    public static final String USER_SUCCESS_MSG = "User created successfully";

    public static final int SUCCESS_CODE = 200;
    public static final String FAILED_REGISTRATION = "Registration failed";
    public static final String FAILED_MSG = "Failed";
    public static final int FAIL_CODE = 500;


    public static String generateRandomNumbers(String startingDigit, int length) {
        StringBuilder builder = new StringBuilder(startingDigit);
        int randomNumberLength = length - (startingDigit.length() + 1);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }
        return builder.toString();
    }
}
