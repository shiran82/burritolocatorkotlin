package com.example.shiranpeer.burritolocator.util;

public class StringUtil {
    public static String dollarBuilder(int priceLevel) {
        StringBuilder dollars = new StringBuilder();
        for (int i = 0; i < priceLevel; i++) {
            dollars.append("$");
        }

        return dollars.toString();
    }
}
