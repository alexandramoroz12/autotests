package main.java.hw_3_testng_java;

public class Task1TestNGJava {

    public static int minOfThreeIntNumbers(int arr[]) {

        int min_value = arr[0];

        for (int el : arr) {
            min_value = min_value < el ? min_value : el;
        }

        return min_value;

    }

}
