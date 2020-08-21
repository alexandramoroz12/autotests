package main.java.hw_2_java;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */

public class Task5 {

    public static void main(String[] args) {
        System.out.println(reverse("Hello world!!!"));
    }

    public static String reverse(String str) {
        int strLength = str.length();
        String result = "";
        for (int i = 0; i < strLength; i++ ){
            result = str.charAt(i) + result;
        }
        return result;
    }
}
