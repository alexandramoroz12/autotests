package main.java.hw_3_testng_java;

public class Task5TestNGJava {

    public static String returnReverseString (String str) {

        int strLength = str.length();
        String result = "";

        for (int i = 0; i < strLength; i++ ){
            result = str.charAt(i) + result;
        }
        return result;
    }
}

